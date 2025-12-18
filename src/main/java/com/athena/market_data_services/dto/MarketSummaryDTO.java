package com.athena.market_data_services.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MarketSummaryDTO {
    private String symbol;
    private String name;
    private Double lastPrice;      // Use wrapper to avoid type issues
    private Double totalVolume;    // Use wrapper to avoid type issues
}
