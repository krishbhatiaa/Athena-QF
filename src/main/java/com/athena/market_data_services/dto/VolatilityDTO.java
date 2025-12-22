package com.athena.market_data_services.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VolatilityDTO {

    private String symbol;
    private int window;
    private double volatility;
}
