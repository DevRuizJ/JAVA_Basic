package com.udemy.productservice.Service.Implement;

import com.udemy.productservice.Entity.Product;
import com.udemy.productservice.Repository.IProductRepository;
import com.udemy.productservice.Service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductImpl implements IProductService {

    @Autowired
    private IProductRepository repo;

    @Override
    @Transactional(readOnly = true)
    public List<Product> findALl() {
        return (List<Product>) repo.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Product findById(Long id) {
        return repo.findById(id).orElse(null);
    }
}
