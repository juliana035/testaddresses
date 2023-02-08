package com.Coffeetest.service;

import com.Coffeetest.client.ViaCepFeignClient;
import com.Coffeetest.model.Addresses;
import org.springframework.stereotype.Service;

@Service
public class CepService {
    private ViaCepFeignClient viaCepFeignClient;
    public CepService(ViaCepFeignClient viaCepFeignClient){
        this.viaCepFeignClient = viaCepFeignClient;
    }

    public Addresses getCep (String cep ){
        Addresses addresses = viaCepFeignClient.getCep(cep);
        return addresses;


    }

}

