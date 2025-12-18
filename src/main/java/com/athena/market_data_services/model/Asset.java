package com.athena.market_data_services.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "assets")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Asset {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String symbol;

    private String name;

    private String assetType;
    @OneToMany(mappedBy = "asset", cascade = CascadeType.ALL)
    private java.util.List<MarketPrice> prices;
}
