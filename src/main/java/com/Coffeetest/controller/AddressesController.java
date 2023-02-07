package com.Coffeetest.controller;

import com.Coffeetest.model.Addresses;
import com.Coffeetest.service.CepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/addresses")
public class AddressesController {


        @Autowired
        private CepService cepService;

        @GetMapping("/{cep}")
        public ResponseEntity<Addresses> getCep(@PathVariable String cep) {

            Addresses endereco = cepService.getCep(cep);

            return endereco != null ? ResponseEntity.ok().body(endereco) : ResponseEntity.notFound().build();
        }

    }

