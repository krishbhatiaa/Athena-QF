package com.athena.market_data_services.quant.model;

import java.time.Instant;

public class VolatilityPoint {

    private Instant timestamp;
    private double volatility;

    public VolatilityPoint(Instant timestamp, double volatility) {
        this.timestamp = timestamp;
        this.volatility = volatility;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public double getVolatility() {
        return volatility;
    }
}
