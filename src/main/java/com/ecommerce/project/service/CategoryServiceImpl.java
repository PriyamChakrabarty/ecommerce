package com.ecommerce.project.service;

import com.ecommerce.project.model.Category;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    private int id = 1 ;

    List<Category> catagories = new ArrayList<Category>();
    @Override
    public List<Category> getCatagories() {
        return catagories;
    }

    @Override
    public void createCatagory(Category category) {
        category.setCatagory_id(id++);
        catagories.add(category);

    }

    @Override
    public String deletecatagory(int id) {
        Category category = catagories.stream()
                .filter(obj -> obj.getCatagory_id() == id).findFirst()
//                .orElse(null);
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND , "Category not found"));
        if (category == null) {
            return "Category not found";
        }
        catagories.remove(category);
        return "category deleted with id: " + id;
    }

    @Override
    public Category updateCategory(Category category, int id) {
        Optional<Category> category1 = catagories.stream()
                .filter(c -> c.getCatagory_id() == id)
                .findFirst();
        if(category1.isPresent()) {
            Category category2 = category1.get();
            category2.setCatagory_name(category.getCatagory_name());
            return category2;
        }
        else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND , "Category not found");
        }

    }
}
