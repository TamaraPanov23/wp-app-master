package com.review_app.model.dto;

import lombok.Data;

@Data
public class ProductDto {

    private String name;

    private Double price;

    private String description;

    private Long category;

    public ProductDto() {
    }

    public ProductDto(String name, String description,Double price, Long category) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
    }
}
