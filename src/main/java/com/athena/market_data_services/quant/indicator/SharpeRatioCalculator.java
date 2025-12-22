package com.athena.market_data_services.quant.indicator;

import com.athena.market_data_services.quant.model.TimeSeriesPoint;

import java.util.List;

public class SharpeRatioCalculator {

    public static double calculate(List<TimeSeriesPoint> returns) {
        if (returns.isEmpty()) return 0.0;

        double mean = returns.stream()
                .mapToDouble(TimeSeriesPoint::getValue)
                .average()
                .orElse(0.0);

        double variance = returns.stream()
                .mapToDouble(p -> Math.pow(p.getValue() - mean, 2))
                .average()
                .orElse(0.0);

        double stdDev = Math.sqrt(variance);

        if (stdDev == 0) return 0.0;

        return mean / stdDev;
    }
}
