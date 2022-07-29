package com.test.challenge.product.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private long id;
    private String name;
    private long producer;
    private String description;
    private String pictureUrl;
    private BigDecimal price;
    private BigDecimal historicalBestPrice;
    private LocalDate bestPriceDate;
    private BigDecimal rating;
    private String producerName;
}
