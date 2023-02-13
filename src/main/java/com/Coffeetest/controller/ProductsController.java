package com.Coffeetest.controller;


import com.Coffeetest.model.ProductModel;
import com.Coffeetest.repository.ProductRepository;
import dto.ProductDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductsController {
    @Autowired
    private ProductRepository productRepository;

    //@GetMapping
    //public ResponseEntity<List<Product>> getAll() {
    // return ResponseEntity.ok(productRepository.findAll());

    //}
    @GetMapping
    public Page<ProductDto> getAll(@RequestParam(required = false) String product,
                                   @RequestParam int page,
                                   @RequestParam int qtd) {
        Pageable pageable = PageRequest.of(page, qtd);
        Page<ProductModel.Product> products = productRepository.findAll(pageable);
        return ProductDto.convert(products);
    }


    @GetMapping("/{id}")
    public ResponseEntity<ProductModel.Product> GetById(@PathVariable Long id) {
        return productRepository.findById(id).map(response -> ResponseEntity.ok(response))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping
    public ResponseEntity<ProductModel.Product> post(@Valid @RequestBody ProductModel.Product product) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productRepository.save(product));

    }

    @PutMapping
    public ResponseEntity<ProductModel.Product> put(@Valid @RequestBody ProductModel.Product product) {
        if (productRepository.existsById(product.getId()))
            return ResponseEntity.status(HttpStatus.OK).body(productRepository.save(product));

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        Optional<ProductModel.Product> product = productRepository.findById(id);

        if (product.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        productRepository.deleteById(id);
    }
}
