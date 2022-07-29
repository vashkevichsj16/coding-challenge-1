package com.test.challenge.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

import static com.fasterxml.jackson.annotation.JsonFormat.Shape.NUMBER;
import static com.fasterxml.jackson.annotation.JsonFormat.Shape.STRING;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    @JsonProperty(required = true, access = JsonProperty.Access.READ_ONLY)
    @JsonFormat(shape = NUMBER)
    private long id;
    @JsonProperty(required = true)
    @JsonFormat(shape = STRING)
    private String name;
    @JsonProperty(required = true)
    @JsonFormat(shape = NUMBER)
    private long producer;
    @JsonFormat(shape = STRING)
    private String description;
    @JsonFormat(shape = STRING)
    private String pictureUrl;
    @JsonFormat(shape = NUMBER)
    private BigDecimal price;
    @JsonFormat(shape = NUMBER)
    private BigDecimal historicalBestPrice;
    @JsonFormat(shape = STRING, pattern = "yyyy-MM-dd")
    private LocalDate bestPriceDate;
    @JsonFormat(shape = NUMBER)
    private BigDecimal rating;
    @JsonFormat(shape = STRING)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String producerName;
}
