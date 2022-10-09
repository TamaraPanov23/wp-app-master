package com.review_app.service;

import com.review_app.model.Product;
import com.review_app.model.dto.ProductDto;
import org.hibernate.procedure.spi.ParameterRegistrationImplementor;

import java.util.List;
import java.util.Optional;
import java.util.Spliterator;

public interface ProductService {

    List<Product> findAll();

    Optional<Product> findById(Long id);

    Optional<Product> findByName(String name);

    Optional<Product> save(String name, String description, Double price, Long category);

    Optional<Product> save(ProductDto productDto);

    Optional<Product> edit(Long id,String name, String description, Double price, Long category);

    Optional<Product> edit(Long id, ProductDto productDto);

    void deleteById(Long id);

}
