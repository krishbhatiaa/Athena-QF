package com.athena.market_data_services.dto;

import java.time.LocalDateTime;

public class SharpeRatioDTO {

    private LocalDateTime timestamp;
    private double sharpeRatio;

    public SharpeRatioDTO(LocalDateTime timestamp, double sharpeRatio) {
        this.timestamp = timestamp;
        this.sharpeRatio = sharpeRatio;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public double getSharpeRatio() {
        return sharpeRatio;
    }
}
