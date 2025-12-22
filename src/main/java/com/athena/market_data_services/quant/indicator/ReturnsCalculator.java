package com.athena.market_data_services.quant.indicator;

import com.athena.market_data_services.quant.model.TimeSeriesPoint;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ReturnsCalculator {

    // Log returns
    public static List<TimeSeriesPoint> logReturns(List<TimeSeriesPoint> series) {

        List<TimeSeriesPoint> sorted =
                series.stream()
                        .sorted(Comparator.comparing(TimeSeriesPoint::getTimestamp))
                        .toList();

        List<TimeSeriesPoint> returns = new ArrayList<>();

        for (int i = 1; i < sorted.size(); i++) {

            double prev = sorted.get(i - 1).getValue();
            double curr = sorted.get(i).getValue();

            if (prev <= 0) continue;

            double logReturn = Math.log(curr / prev);

            returns.add(
                    new TimeSeriesPoint(
                            sorted.get(i).getTimestamp(),
                            logReturn
                    )
            );
        }

        return returns;
    }
}
