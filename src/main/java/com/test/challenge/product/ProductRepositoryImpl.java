package com.test.challenge.product;

import com.test.challenge.filter.Filter;
import com.test.challenge.product.entity.Product;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.persistence.EntityNotFoundException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Simple idea of repository
 */
@Service
public class ProductRepositoryImpl implements ProductRepository {
    private Map<Long, Product> fakeRepository;

    @PostConstruct
    private void didInitialize() {
        fakeRepository = new HashMap<>();
    }

    /**
     * Use of magic numbers or plain counter is not well done,
     * but this file is just simple idea of repository
     */
    private long counter = 1;

    @Override
    public Product getProduct(long id) {
        return Optional.ofNullable(fakeRepository.get(id))
                .orElseThrow(
                        EntityNotFoundException::new
                );
    }

    @Override
    public Collection<Product> getProducts() {
        return fakeRepository.values();
    }


    // TODO finish it
    @Override
    public Collection<Product> getProducts(Filter filter) {
        throw new IllegalStateException("Method not implemented");
    }

    @Override
    public Product addProduct(Product product) {
        if (fakeRepository.containsKey(product.getId())) {
            throw new IllegalArgumentException("Element with current id already exists");
        }
        long id = ++counter;
        product.setId(id);
        fakeRepository.put(id, product);
        return product;
    }

    @Override
    public Collection<Product> addProducts(Collection<Product> product) {
        return product.stream()
                .map(
                        this::addProduct
                ).collect(Collectors.toList());
    }
}
