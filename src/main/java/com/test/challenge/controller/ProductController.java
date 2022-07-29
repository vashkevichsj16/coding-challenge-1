package com.test.challenge.controller;

import com.test.challenge.dto.FilterDto;
import com.test.challenge.dto.ProductDto;
import com.test.challenge.mapper.FilterDtoMapper;
import com.test.challenge.mapper.ProductDtoMapper;
import com.test.challenge.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;


@RestController()
@RequestMapping("/product")
// Should be resolved on proxy server level but for locale runs is here
@CrossOrigin
public class ProductController {

    @Autowired
    public ProductService productService;

    @Autowired
    public ProductDtoMapper productDtoMapper;

    @Autowired
    public FilterDtoMapper filterDtoMapper;


    @GetMapping(value = "/all", produces = "application/json")

    public ResponseEntity<Collection<ProductDto>> getProducts() {
        return new ResponseEntity<>(productDtoMapper.toDto(productService.getProducts()),
                HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<ProductDto> getProduct(@PathVariable long id) {
        return new ResponseEntity<>(productDtoMapper.toDto(productService.getProduct(id)),
                HttpStatus.OK);
    }

    @PostMapping(value = "/add", produces = "application/json")
    public ResponseEntity<ProductDto> addProduct(@RequestBody ProductDto productDto) {
        return new ResponseEntity<>(productDtoMapper.toDto(
                productService.addProduct(
                        productDtoMapper.toEntity(productDto))),
                HttpStatus.OK);
    }

    @PostMapping(value = "/filter", produces = "application/json")
    public ResponseEntity<Collection<ProductDto>> getProducts(@RequestBody FilterDto filter) {
        return new ResponseEntity<>(productDtoMapper.toDto(productService.getProducts(filterDtoMapper.toEntity(filter))),
                HttpStatus.OK);

    }
}
