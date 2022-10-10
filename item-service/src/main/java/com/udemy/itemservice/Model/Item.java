package com.udemy.itemservice.Model;

public class Item {

    private Product _product;
    private Integer _quantity;

    public Item(){}

    public Item(Product product, Integer quantity){
        _product = product;
        _quantity = quantity;
    }

    public Product getProduct() {
        return _product;
    }

    public void setProduct(Product product) {
        this._product = product;
    }

    public Integer getQuantity() {
        return _quantity;
    }

    public void setQuantity(Integer quantity) {
        this._quantity = quantity;
    }

    public Double getTotal(){
        return _product.getPrice() * _quantity.doubleValue();
    }
}
