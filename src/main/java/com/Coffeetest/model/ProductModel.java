package com.Coffeetest.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class ProductModel {
    @Data
    @Entity
    @Table(name = "tb_products")
    public class Product {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @NotBlank(message = "Please enter your name")
        @Size(min = 2, max = 80, message = "Minimum 03 and maximum 80 characters!")
        private String nameProducts;
        private String size;
        private String descriptionProducts;
        private String imageProducts;
        @NotNull(message = "This price attribute is mandatory!")
        private Double price;
        @UpdateTimestamp
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        private LocalDate data;


    }

}
