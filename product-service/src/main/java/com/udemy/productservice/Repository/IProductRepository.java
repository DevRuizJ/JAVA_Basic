package com.udemy.productservice.Repository;

import com.udemy.productservice.Entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface IProductRepository extends CrudRepository<Product, Long> {
}
