package com.athena.market_data_services.repository;

import com.athena.market_data_services.model.MarketPrice;
import com.athena.market_data_services.model.Asset;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MarketPriceRepository extends JpaRepository<MarketPrice, Long> {
    List<MarketPrice> findByAsset(Asset asset);
}
