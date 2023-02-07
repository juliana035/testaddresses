package com.Coffeetest.service;

import com.Coffeetest.client.ViaCepFeignClient;
import com.Coffeetest.controller.AddressesController;
import com.Coffeetest.model.Addresses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CepService {
    private ViaCepFeignClient viaCepFeignClient;
    @Autowired
    public CepService(ViaCepFeignClient viaCepFeignClient){
        this.viaCepFeignClient = viaCepFeignClient;
    }

    public Addresses getCep (String cep ){
        Addresses addresses = new Addresses();
        addresses.setCep(cep);
        return addresses;


    }

}

