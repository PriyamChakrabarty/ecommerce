package com.ecommerce.project.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity(name = "categories")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int categoryId;

    @NotBlank
    @Size(min = 5, message = "Category must min 5")
    private String categoryName;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Product> products;

//    public Category(int catagory_id, String catagory_name) {
//        this.catagory_id = catagory_id;
//        this.catagory_name = catagory_name;
//    }
//
//    public Category() {
//    }
//
//    public int getCatagory_id() {
//        return catagory_id;
//    }
//
//    public String getCatagory_name() {
//        return catagory_name;
//    }
//    public void setCatagory_id(int catagory_id) {
//        this.catagory_id = catagory_id;
//    }
//    public void setCatagory_name(String catagory_name) {
//        this.catagory_name = catagory_name;
//    }

}
