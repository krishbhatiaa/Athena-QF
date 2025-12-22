package com.athena.market_data_services.controller;

import com.athena.market_data_services.dto.RollingVolatilityDTO;
import com.athena.market_data_services.dto.SignalDTO;
import com.athena.market_data_services.service.QuantService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quant")
public class QuantController {

    private final QuantService quantService;

    public QuantController(QuantService quantService) {
        this.quantService = quantService;
    }

    // GET /api/quant/volatility/{symbol}?window=5
    @GetMapping("/volatility/{symbol}")
    public List<RollingVolatilityDTO> volatility(
            @PathVariable String symbol,
            @RequestParam int window
    ) {
        return quantService.calculateRollingVolatility(symbol, window);
    }

    // GET /api/quant/signal/{symbol}?window=5
    @GetMapping("/signal/{symbol}")
    public SignalDTO signal(
            @PathVariable String symbol,
            @RequestParam int window
    ) {
        return quantService.latestVolatilitySignal(symbol, window);
    }
}
