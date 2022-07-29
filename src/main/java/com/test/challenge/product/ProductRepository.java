package com.test.challenge.product;

import com.test.challenge.filter.Filter;
import com.test.challenge.product.entity.Product;

import java.util.Collection;

public interface ProductRepository {

    Product getProduct(long id);

    Collection<Product> getProducts();

    //Filter for api with filters
    Collection<Product> getProducts(Filter filter);

    Product addProduct(Product product);

    Collection<Product> addProducts(Collection<Product> product);
}
