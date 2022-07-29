package com.test.challenge.product;

import com.test.challenge.filter.Filter;
import com.test.challenge.producer.ProducerService;
import com.test.challenge.product.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    public ProductRepository productRepository;

    @Autowired
    public ProducerService producerService;

    @Override
    public Product getProduct(long id) {
        return enrichProductByProducerName(productRepository.getProduct(id));
    }

    @Override
    public Collection<Product> getProducts() {
        return productRepository.getProducts().stream()
                .map(this::enrichProductByProducerName)
                .collect(Collectors.toList());
    }

    @Override
    public List<Product> getProducts(Filter filter) {
        return productRepository.getProducts(filter).stream()
                .map(this::enrichProductByProducerName)
                .collect(Collectors.toList());
    }

    @Override
    public Product addProduct(Product product) {
        return productRepository.addProduct(product);
    }

    private Product enrichProductByProducerName(Product product) {
        product.setProducerName(producerService.getProducerNameById(product.getProducer()));
        return product;
    }
}
