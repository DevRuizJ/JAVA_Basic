package com.udemy.itemservice.Service;

import com.udemy.itemservice.Model.Item;

import java.util.List;

public interface IItemService {

    public List<Item> findAll();
    public Item findById(Long id, Integer quantity);
}
