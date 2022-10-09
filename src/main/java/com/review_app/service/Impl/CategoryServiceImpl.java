package com.review_app.service.Impl;

import com.review_app.model.Category;
import com.review_app.repository.CategoryRepository;
import com.review_app.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category create(String name, String description) {

        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException();
        }

        Category category = new Category(name, description);
        categoryRepository.save(category);
        return category;
    }

    @Override
    public Category update(String name, String description) {

        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException();
        }

        Category category = new Category(name, description);
        categoryRepository.save(category);
        return category;
    }

    @Override
    public void delete(String name) {

        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException();
        }

        categoryRepository.deleteByName(name);

    }

    @Override
    public List<Category> listAll() {
        return categoryRepository.findAll();
    }

    @Override
    public List<Category> searchCategories(String text) {
        return categoryRepository.findAllByNameLike(text);
    }
}
