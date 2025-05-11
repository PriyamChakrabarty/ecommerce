package com.ecommerce.project.service;

import com.ecommerce.project.model.Category;

import java.util.List;

public interface CategoryService {
    public List<Category> getCatagories();
    void createCatagory(Category category);

    String deletecatagory(int id);

    Category updateCategory(Category category, int id);
}
