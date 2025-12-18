package com.athena.market_data_services.service;

import com.athena.market_data_services.model.Asset;
import com.athena.market_data_services.model.MarketPrice;
import com.athena.market_data_services.repository.AssetRepository;
import com.athena.market_data_services.repository.MarketPriceRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    private final AssetRepository assetRepository;
    private final MarketPriceRepository marketPriceRepository;

    public DataLoader(AssetRepository assetRepository,
                      MarketPriceRepository marketPriceRepository) {
        this.assetRepository = assetRepository;
        this.marketPriceRepository = marketPriceRepository;
    }

    @Override
    public void run(String... args) {

        Asset apple = new Asset();
        apple.setSymbol("AAPL");
        apple.setName("Apple Inc.");
        apple.setAssetType("EQUITY");

        assetRepository.save(apple);

        List<MarketPrice> prices = List.of(
                new MarketPrice(null, 180.2, 1200000, LocalDateTime.now().minusDays(4), apple),
                new MarketPrice(null, 181.5, 1350000, LocalDateTime.now().minusDays(3), apple),
                new MarketPrice(null, 179.9, 1100000, LocalDateTime.now().minusDays(2), apple),
                new MarketPrice(null, 182.3, 1600000, LocalDateTime.now().minusDays(1), apple)
        );

        marketPriceRepository.saveAll(prices);

        System.out.println("✔ Dummy market data loaded");
    }
}
