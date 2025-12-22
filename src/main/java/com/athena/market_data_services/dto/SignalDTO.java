package com.athena.market_data_services.dto;

import java.time.LocalDateTime;

public class SignalDTO {

    private LocalDateTime timestamp;
    private String signal;
    private double value;

    public SignalDTO(LocalDateTime timestamp, String signal, double value) {
        this.timestamp = timestamp;
        this.signal = signal;
        this.value = value;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getSignal() {
        return signal;
    }

    public double getValue() {
        return value;
    }
}
