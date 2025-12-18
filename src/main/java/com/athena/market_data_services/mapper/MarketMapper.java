package com.athena.market_data_services.mapper;

import com.athena.market_data_services.dto.MarketSummaryDTO;
import com.athena.market_data_services.model.Asset;
import com.athena.market_data_services.model.MarketPrice;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;

@Component
public class MarketMapper {

    public MarketSummaryDTO toDTO(Asset asset, List<MarketPrice> prices) {
        if (prices.isEmpty()) {
            return new MarketSummaryDTO(
                    asset.getSymbol(),
                    asset.getName(),
                    0.0,
                    0.0
            );
        }

        // Latest price = last by timestamp
        double latestPrice = prices.stream()
                .max(Comparator.comparing(MarketPrice::getTimestamp))
                .get()
                .getPrice();

        // Total volume
        double totalVolume = prices.stream()
                .mapToDouble(MarketPrice::getVolume)
                .sum();

        return new MarketSummaryDTO(
                asset.getSymbol(),
                asset.getName(),
                latestPrice,
                totalVolume
        );
    }
}
