package com.athena.market_data_services.service;
import com.athena.market_data_services.dto.SignalDTO;
import com.athena.market_data_services.quant.signal.VolatilitySignalGenerator;

import com.athena.market_data_services.dto.RollingVolatilityDTO;
import com.athena.market_data_services.mapper.QuantMapper;
import com.athena.market_data_services.model.Asset;
import com.athena.market_data_services.model.MarketPrice;
import com.athena.market_data_services.quant.indicator.ReturnsCalculator;
import com.athena.market_data_services.quant.indicator.VolatilityCalculator;
import com.athena.market_data_services.quant.model.TimeSeriesPoint;
import com.athena.market_data_services.repository.AssetRepository;
import com.athena.market_data_services.repository.MarketPriceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuantService {

    private final AssetRepository assetRepository;
    private final MarketPriceRepository marketPriceRepository;
    private final QuantMapper quantMapper;

    public QuantService(
            AssetRepository assetRepository,
            MarketPriceRepository marketPriceRepository,
            QuantMapper quantMapper
    ) {
        this.assetRepository = assetRepository;
        this.marketPriceRepository = marketPriceRepository;
        this.quantMapper = quantMapper;
    }

    public List<RollingVolatilityDTO> calculateRollingVolatility(
            String symbol,
            int window
    ) {

        // 1. Asset lookup
        Asset asset = assetRepository.findBySymbol(symbol)
                .orElseThrow(() ->
                        new RuntimeException("Asset not found: " + symbol));

        // 2. Fetch prices
        List<MarketPrice> prices =
                marketPriceRepository.findByAsset(asset);

        // 3. Prices → TimeSeries
        List<TimeSeriesPoint> priceSeries =
                quantMapper.toTimeSeries(prices);

        // 4. TimeSeries → Log Returns
        List<TimeSeriesPoint> returns =
                ReturnsCalculator.logReturns(priceSeries);

        // 5. Returns → Rolling Volatility
        List<TimeSeriesPoint> volatility =
                VolatilityCalculator.rollingVolatility(returns, window);

        // 6. Volatility → DTO
        return quantMapper.toRollingVolatilityDTO(volatility);
    }
    public SignalDTO latestVolatilitySignal(
            String symbol,
            int window
    ) {

        // Reuse rolling volatility logic
        List<RollingVolatilityDTO> vol =
                calculateRollingVolatility(symbol, window);

        if (vol.isEmpty()) {
            throw new RuntimeException("Not enough data to generate signal");
        }

        // Take the most recent volatility point
        RollingVolatilityDTO latest =
                vol.get(vol.size() - 1);

        // Generate signal
        return new SignalDTO(
                latest.getTimestamp(),
                VolatilitySignalGenerator
                        .generate(latest.getVolatility())
                        .name(),

                latest.getVolatility()
        );
    }

}
