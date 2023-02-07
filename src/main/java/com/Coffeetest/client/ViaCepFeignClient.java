package com.Coffeetest.client;

import com.Coffeetest.controller.AddressesController;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "viacep", url = "https://viacep.com.br/ws")
public interface ViaCepFeignClient {

@GetMapping
AddressesController getCep (@PathVariable(value = "cep") String cep);

}
