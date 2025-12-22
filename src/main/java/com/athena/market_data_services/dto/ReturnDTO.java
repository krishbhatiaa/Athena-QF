package com.athena.market_data_services.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class ReturnDTO {

    private LocalDateTime timestamp;
    private double returnValue;

    public ReturnDTO(LocalDateTime timestamp, double returnValue) {
        this.timestamp = timestamp;
        this.returnValue = returnValue;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public double getReturnValue() {
        return returnValue;
    }
}
