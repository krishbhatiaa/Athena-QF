package com.athena.market_data_services.quant.indicator;

import com.athena.market_data_services.quant.model.TimeSeriesPoint;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MovingAverageCalculator {

    public static List<TimeSeriesPoint> simpleMovingAverage(
            List<TimeSeriesPoint> series,
            int window
    ) {
        List<TimeSeriesPoint> result = new ArrayList<>();

        // Always sort by timestamp
        series.sort(Comparator.comparing(TimeSeriesPoint::getTimestamp));

        for (int i = window - 1; i < series.size(); i++) {
            double sum = 0.0;

            for (int j = i - window + 1; j <= i; j++) {
                sum += series.get(j).getValue();
            }

            double avg = sum / window;

            result.add(
                    new TimeSeriesPoint(
                            series.get(i).getTimestamp(),
                            avg
                    )
            );
        }

        return result;
    }
}
