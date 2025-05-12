package com.ecommerce.project.controller;

import com.ecommerce.project.model.Category;
import com.ecommerce.project.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CategoryController {

    @Autowired
    private CategoryService catagoryService;

//    public CategoryController(CategoryService catagoryService) {
//        this.catagoryService = catagoryService;
//    }

    //@GetMapping("/api/public/catagories")
    @RequestMapping(value = "/public/catagories", method = RequestMethod.GET)
    public ResponseEntity<List<Category>> getCatagories() {
        List<Category> catagories = catagoryService.getCatagories();
        return new ResponseEntity<>(catagories,HttpStatus.OK);
    }

    @PostMapping("/public/catagories")
    public ResponseEntity<String> createCatagory(@Valid @RequestBody Category category, SessionStatus sessionStatus) {
        catagoryService.createCatagory(category);
        return new ResponseEntity<>("Category created",HttpStatus.CREATED);
    }

    @DeleteMapping("/admin/catagories/{id}")
    public ResponseEntity<String> deleteCatagory(@PathVariable int id) {
        try {
        String status = catagoryService.deletecatagory(id);
        //return new ResponseEntity<>(status, HttpStatus.OK);
            return ResponseEntity.status(HttpStatus.OK).body(status);
            //trying different Response entity method
        }
        catch (ResponseStatusException e) {
            return new ResponseEntity<>(e.getReason(),e.getStatusCode());
        }

    }
    @PutMapping("/public/catagories/{id}")
    public ResponseEntity<String> updateCatagory(@RequestBody Category category, @PathVariable int id) {
        Category category1 = catagoryService.updateCategory(category,id);
        return new ResponseEntity<>("Category updated"+category1,HttpStatus.OK);

    }

}
