package com.udemy.itemservice.Service.Implement;

import com.udemy.itemservice.Model.Item;
import com.udemy.itemservice.Model.Product;
import com.udemy.itemservice.Service.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service("restTemplateService")
public class ItemImpl implements IItemService {

    @Autowired
    private RestTemplate rest;

    @Override
    public List<Item> findAll() {

        List<Product> products = Arrays.asList(rest.getForObject("http://product-service/list", Product[].class));

        return products.stream().map(p -> new Item(p, 1)).collect(Collectors.toList());
    }

    @Override
    public Item findById(Long id, Integer quantity) {

        Map<String, String> pathVariables = new HashMap<String, String>();
        pathVariables.put("id", id.toString());

        Product product = rest.getForObject("http://product-service/detail/{id}", Product.class, pathVariables);

        return new Item(product, quantity);
    }
}
