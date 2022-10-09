package com.review_app.service;


import com.review_app.model.Category;

import java.util.List;

public interface CategoryService {

    Category create(String name, String description);

    Category update(String name, String description);

    void delete(String name);

    List<Category> listAll();

    List<Category> searchCategories(String text);
}
