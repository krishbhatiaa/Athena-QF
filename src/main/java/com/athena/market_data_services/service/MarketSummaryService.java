package com.athena.market_data_services.service;
import com.athena.market_data_services.exception.AssetNotFoundException;

import com.athena.market_data_services.dto.MarketSummaryDTO;
import com.athena.market_data_services.mapper.MarketMapper;
import com.athena.market_data_services.model.Asset;
import com.athena.market_data_services.model.MarketPrice;
import com.athena.market_data_services.repository.AssetRepository;
import com.athena.market_data_services.repository.MarketPriceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MarketSummaryService {

    private final AssetRepository assetRepository;
    private final MarketPriceRepository marketPriceRepository;
    private final MarketMapper marketMapper;

    public MarketSummaryService(AssetRepository assetRepository,
                                MarketPriceRepository marketPriceRepository,
                                MarketMapper marketMapper) {
        this.assetRepository = assetRepository;
        this.marketPriceRepository = marketPriceRepository;
        this.marketMapper = marketMapper;
    }

    // Get summary for all assets
    public List<MarketSummaryDTO> getMarketSummaryForAllAssets() {
        return assetRepository.findAll()
                .stream()
                .map(asset -> {
                    List<MarketPrice> prices = marketPriceRepository.findByAsset(asset);
                    return marketMapper.toDTO(asset, prices);
                })
                .collect(Collectors.toList());
    }

    // Get summary for a single asset by symbol
    public MarketSummaryDTO getMarketSummaryForAsset(String symbol) {
        Asset asset = assetRepository.findBySymbol(symbol)
                .orElseThrow(() -> new AssetNotFoundException("Asset not found: " + symbol));


        List<MarketPrice> prices = marketPriceRepository.findByAsset(asset);
        return marketMapper.toDTO(asset, prices);
    }
}
