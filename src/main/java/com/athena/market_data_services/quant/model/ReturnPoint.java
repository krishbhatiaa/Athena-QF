package com.athena.market_data_services.quant.model;

import java.time.Instant;

public class ReturnPoint {

    private Instant timestamp;
    private double logReturn;

    public ReturnPoint(Instant timestamp, double logReturn) {
        this.timestamp = timestamp;
        this.logReturn = logReturn;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public double getLogReturn() {
        return logReturn;
    }
}
