package com.udemy.productservice.Service;

import com.udemy.productservice.Entity.Product;

import java.util.List;

public interface IProductService {

    public List<Product> findALl();
    public Product findById(Long id);

}
