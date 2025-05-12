package com.ecommerce.project.service;

import com.ecommerce.project.com.ecommerce.project.repositories.CategoryRepository;
import com.ecommerce.project.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    //List<Category> catagories = new ArrayList<Category>();

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<Category> getCatagories() {
        return categoryRepository.findAll();
    }

    @Override
    public void createCatagory(Category category) {
        categoryRepository.save(category);

    }

    @Override
    public String deletecatagory(int id) {
        /*
        List<Category> catagories = categoryRepository.findAll();
        Category category = catagories.stream()
                .filter(obj -> obj.getCatagory_id() == id).findFirst()
//                .orElse(null);
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND , "Category not found"));
        if (category == null) {
            return "Category not found";
        }*/

        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        categoryRepository.delete(category);
        return "category deleted with id: " + id;
    }

    @Override
    public Category updateCategory(Category category, int id) {
        Optional<Category> catagories = categoryRepository.findById(id);
        Category savedCategory = catagories
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND , "Category not found"));
        savedCategory.setCatagory_name(category.getCatagory_name());
        savedCategory = categoryRepository.save(savedCategory);
        return savedCategory;

//        Optional<Category> category1 = catagories.stream()
//                .filter(c -> c.getCatagory_id() == id)
//                .findFirst();
//        if(category1.isPresent()) {
//            Category category2 = category1.get();
//            category2.setCatagory_name(category.getCatagory_name());
//            Category savedcategory=categoryRepository.save(category2);
//            return savedcategory;
//        }
//        else {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND , "Category not found");
//        }

    }
}
