package com.athena.market_data_services.mapper;

import com.athena.market_data_services.dto.RollingVolatilityDTO;
import com.athena.market_data_services.model.MarketPrice;
import com.athena.market_data_services.quant.model.TimeSeriesPoint;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;

@Component
public class QuantMapper {

    /**
     * MarketPrice → TimeSeriesPoint (prices)
     */
    public List<TimeSeriesPoint> toTimeSeries(List<MarketPrice> prices) {
        return prices.stream()
                .sorted(Comparator.comparing(MarketPrice::getTimestamp))
                .map(p -> new TimeSeriesPoint(
                        p.getTimestamp(),
                        p.getPrice()
                ))
                .toList();
    }

    /**
     * TimeSeriesPoint (volatility) → DTO
     */
    public List<RollingVolatilityDTO> toRollingVolatilityDTO(
            List<TimeSeriesPoint> volatilitySeries
    ) {
        return volatilitySeries.stream()
                .map(p -> new RollingVolatilityDTO(
                        p.getTimestamp(),
                        p.getValue()
                ))
                .toList();
    }
}
