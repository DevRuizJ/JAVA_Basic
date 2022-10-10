package com.udemy.itemservice.Client;

import com.udemy.itemservice.Model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "product-service"/*, url = "${product-service.ribbon.listOfServers}"*/)
public interface ProductRestClient {

    @GetMapping("/list")
    public List<Product> list();

    @GetMapping("/detail/{id}")
    public Product detail(@PathVariable Long id);

}
