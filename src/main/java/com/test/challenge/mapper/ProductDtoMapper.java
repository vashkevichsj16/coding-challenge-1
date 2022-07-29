package com.test.challenge.mapper;

import com.test.challenge.dto.ProductDto;
import com.test.challenge.product.entity.Product;
import org.mapstruct.Mapper;

import java.util.Collection;

@Mapper
public interface ProductDtoMapper {
    ProductDto toDto(Product source);

    Collection<ProductDto> toDto(Collection<Product> destination);

    Product toEntity(ProductDto destination);

    Collection<Product> toEntity(Collection<ProductDto> destination);
}
