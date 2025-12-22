package com.athena.market_data_services.quant.model;

import java.time.LocalDateTime;

public class TimeSeriesPoint {

    private LocalDateTime timestamp;
    private double value;

    public TimeSeriesPoint(LocalDateTime timestamp, double value) {
        this.timestamp = timestamp;
        this.value = value;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public double getValue() {
        return value;
    }
}
