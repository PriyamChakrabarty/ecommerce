package com.ecommerce.project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "categories")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int catagory_id;

    @NotBlank
    private String catagory_name;

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
