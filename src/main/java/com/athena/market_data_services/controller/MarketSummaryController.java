package com.athena.market_data_services.controller;

import com.athena.market_data_services.dto.MarketSummaryDTO;
import com.athena.market_data_services.service.MarketSummaryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/market")
public class MarketSummaryController {

    private final MarketSummaryService marketSummaryService;

    public MarketSummaryController(MarketSummaryService marketSummaryService) {
        this.marketSummaryService = marketSummaryService;
    }

    // GET /api/market/all or /api/market/all/
    @GetMapping({"/all", "/all/"})
    public ResponseEntity<List<MarketSummaryDTO>> getAllMarketSummary() {
        return ResponseEntity.ok(
                marketSummaryService.getMarketSummaryForAllAssets()
        );
    }

    // GET /api/market/{symbol}
    @GetMapping("/{symbol}")
    public ResponseEntity<MarketSummaryDTO> getMarketSummary(
            @PathVariable String symbol
    ) {
        return ResponseEntity.ok(
                marketSummaryService.getMarketSummaryForAsset(symbol)
        );
    }
}
