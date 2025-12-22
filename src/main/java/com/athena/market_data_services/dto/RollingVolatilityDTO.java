package com.athena.market_data_services.dto;

import java.time.LocalDateTime;

public class RollingVolatilityDTO {

    private LocalDateTime timestamp;
    private double volatility;

    public RollingVolatilityDTO(LocalDateTime timestamp, double volatility) {
        this.timestamp = timestamp;
        this.volatility = volatility;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public double getVolatility() {
        return volatility;
    }
}
