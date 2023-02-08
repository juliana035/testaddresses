package com.Coffeetest.client;

import com.Coffeetest.controller.AddressesController;
import com.Coffeetest.model.Addresses;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "viacep", url = "https://viacep.com.br/ws")
public interface ViaCepFeignClient {

    @GetMapping("/{cep}/json")
    Addresses getCep(@PathVariable(value = "cep") String cep);

}
