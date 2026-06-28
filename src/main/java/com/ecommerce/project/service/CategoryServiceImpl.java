package com.ecommerce.project.service;

import com.ecommerce.project.com.ecommerce.project.repositories.CategoryRepository;
import com.ecommerce.project.model.Category;
import com.ecommerce.project.payload.CategoryDTO;
import com.ecommerce.project.payload.CategoryResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    //List<Category> catagories = new ArrayList<Category>();

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CategoryResponse getCatagories(Integer pageNumber, Integer pageSize, String sortBy, String sortOrder) {
        Sort sortbyorder =  sortOrder.equalsIgnoreCase("asc")
                ?Sort.by(sortBy).ascending()
                :Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNumber, pageSize, sortbyorder);
        Page<Category> categoryPage = categoryRepository.findAll(pageable);
        List<Category> categories = categoryPage.getContent();
        if (categories.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found");
        }


        // manual mapping
        /*
        List<CategoryDTO> categoriesDTO = new ArrayList<>();
        for (Category category : categories) {
            CategoryDTO dto = new CategoryDTO();
            dto.setCategoryId(category.getCategoryId());
            dto.setCategoryName(category.getCategoryName());
            categoriesDTO.add(dto);
        }
        CategoryResponse categoryResponse = new CategoryResponse();
        categoryResponse.setContent(categoriesDTO);
        return categoryResponse;
         */

        // model mapper
        List<CategoryDTO>  categoryDTOS=categories.stream()
                .map(category -> modelMapper.map(category,CategoryDTO.class))
                .toList();
        CategoryResponse categoryResponse = new CategoryResponse();
        categoryResponse.setContent(categoryDTOS);
        categoryResponse.setPageNumber(categoryPage.getNumber());
        categoryResponse.setPageSize(categoryPage.getSize());
        categoryResponse.setTotalPages(categoryPage.getTotalPages());
        categoryResponse.setTotalElements(categoryPage.getNumberOfElements());
        categoryResponse.setLastPage(categoryPage.isLast());
        return categoryResponse;

    }

    @Override
    public CategoryDTO createCatagory(CategoryDTO categorydto) {
        Category catagory = modelMapper.map(categorydto,Category.class);
        Category categoryfromDB = categoryRepository.findByCategoryName(catagory.getCategoryName());
        if(categoryfromDB!=null){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Category already exists");
        }
        Category savcatagory =categoryRepository.save(catagory);
        CategoryDTO newCatagory = modelMapper.map(savcatagory,CategoryDTO.class);
        return newCatagory;
        //return modelMapper.map(categoryRepository.save(catagory), CategoryDTO.class);
    }

    @Override
    public CategoryDTO deletecatagory(int id) {
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


        return modelMapper.map(category,CategoryDTO.class);
    }

    @Override
    public CategoryDTO updateCategory(CategoryDTO categorydto, int id) {
        Category catagories = modelMapper.map(categorydto,Category.class);
        catagories.setCategoryId(id);
        Category savedCategory = categoryRepository.findById(catagories.getCategoryId())
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND , "Category not found"));

        savedCategory = categoryRepository.save(catagories);
        return modelMapper.map(savedCategory,CategoryDTO.class);

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
