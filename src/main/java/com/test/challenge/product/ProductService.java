package com.test.challenge.product;

import com.test.challenge.filter.Filter;
import com.test.challenge.product.entity.Product;

import java.util.Collection;
import java.util.List;

public interface ProductService {

    Product getProduct(long id);

    Collection<Product> getProducts();

    //Filter for api with filters
    List<Product> getProducts(Filter filter);

    Product addProduct(Product product);
}
