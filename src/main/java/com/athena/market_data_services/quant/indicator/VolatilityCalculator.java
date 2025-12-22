package com.athena.market_data_services.quant.indicator;

import com.athena.market_data_services.quant.model.TimeSeriesPoint;

import java.util.ArrayList;
import java.util.List;

public class VolatilityCalculator {

    public static List<TimeSeriesPoint> rollingVolatility(
            List<TimeSeriesPoint> series,
            int window
    ) {
        List<TimeSeriesPoint> result = new ArrayList<>();

        for (int i = window - 1; i < series.size(); i++) {

            double mean = 0.0;
            for (int j = i - window + 1; j <= i; j++) {
                mean += series.get(j).getValue();
            }
            mean /= window;

            double variance = 0.0;
            for (int j = i - window + 1; j <= i; j++) {
                double diff = series.get(j).getValue() - mean;
                variance += diff * diff;
            }
            variance /= window;

            result.add(
                    new TimeSeriesPoint(
                            series.get(i).getTimestamp(),
                            Math.sqrt(variance)
                    )
            );
        }

        return result;
    }
}
