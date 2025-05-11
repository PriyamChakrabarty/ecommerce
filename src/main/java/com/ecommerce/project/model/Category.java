package com.ecommerce.project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int catagory_id;
    private String catagory_name;

    public Category(int catagory_id, String catagory_name) {
        this.catagory_id = catagory_id;
        this.catagory_name = catagory_name;
    }

    public int getCatagory_id() {
        return catagory_id;
    }

    public String getCatagory_name() {
        return catagory_name;
    }
    public void setCatagory_id(int catagory_id) {
        this.catagory_id = catagory_id;
    }
    public void setCatagory_name(String catagory_name) {
        this.catagory_name = catagory_name;
    }

}
