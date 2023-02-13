package com.Coffeetest.repository;


import com.Coffeetest.model.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductModel.Product,Long>{

}
