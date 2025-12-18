package com.athena.market_data_services.repository;
import com.athena.market_data_services.repository.AssetRepository;

import com.athena.market_data_services.model.Asset;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AssetRepository extends JpaRepository<Asset, Long> {

    Optional<Asset> findBySymbol(String symbol);
}
