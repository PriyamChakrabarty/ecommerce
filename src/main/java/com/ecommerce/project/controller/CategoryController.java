package com.ecommerce.project.controller;

import com.ecommerce.project.config.AppConstants;
import com.ecommerce.project.model.Category;
import com.ecommerce.project.payload.CategoryDTO;
import com.ecommerce.project.payload.CategoryResponse;
import com.ecommerce.project.service.CategoryService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
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

    @Autowired
    private ModelMapper modelMapper;


    CategoryResponse categoryResponse;

//    public CategoryController(CategoryService catagoryService) {
//        this.catagoryService = catagoryService;
//    }

    //@GetMapping("/api/public/catagories")
    @RequestMapping(value = "/public/categories", method = RequestMethod.GET)
    public ResponseEntity<CategoryResponse> getCatagories(@RequestParam(name="pageNumber",
                                                                      defaultValue = AppConstants.pageNumber,
                                                                      required = false) Integer pageNumber,
                                                          @RequestParam(name="pageSize",
                                                                  defaultValue = AppConstants.pageSize,
                                                                  required = false) Integer pageSize,
                                                          @RequestParam(name="sortBy",
                                                                  defaultValue = AppConstants.sortBy,required = false) String sortBy,
                                                          @RequestParam(name="sortOrder",
                                                                  defaultValue = AppConstants.sortOrder,required = false) String sortOrder) {
        categoryResponse = catagoryService.getCatagories(pageNumber,pageSize,sortBy,sortOrder);
        System.out.println("pageNumber = " + pageNumber);
        System.out.println("pageSize = " + pageSize);
        System.out.println("sortBy = " + sortBy);
        System.out.println("sortOrder = " + sortOrder);
        return new ResponseEntity<>(categoryResponse,HttpStatus.OK);
    }

    @PostMapping("/public/categories")
    public ResponseEntity<CategoryDTO> createCatagory(@Valid @RequestBody CategoryDTO category, SessionStatus sessionStatus) {
        CategoryDTO savedCat =  catagoryService.createCatagory(category);
        return new ResponseEntity<>(savedCat,HttpStatus.CREATED);
    }

    @DeleteMapping("/admin/categories/{id}")
    public ResponseEntity<CategoryDTO> deleteCatagory(@PathVariable int id) {
        CategoryDTO categoryDTO = new CategoryDTO();
        try {
        categoryDTO  = catagoryService.deletecatagory(id);
        //return new ResponseEntity<>(status, HttpStatus.OK);
            return ResponseEntity.ok(categoryDTO);
            //trying different Response entity method
        }
        catch (ResponseStatusException e) {
            return new ResponseEntity<>(categoryDTO,HttpStatus.NOT_FOUND);
        }

    }
    @PutMapping("/public/categories/{id}")
    public ResponseEntity<CategoryDTO> updateCatagory(@RequestBody CategoryDTO category, @PathVariable int id) {
        CategoryDTO category1 = catagoryService.updateCategory(category,id);
        return new ResponseEntity<>(category1,HttpStatus.OK);

    }


}
