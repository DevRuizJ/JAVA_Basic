package com.udemy.itemservice.Controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.udemy.itemservice.Model.Item;
import com.udemy.itemservice.Model.Product;
import com.udemy.itemservice.Service.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {

    @Autowired
    @Qualifier("feignService")
    //@Qualifier("restTemplateService")
    private IItemService serv;

    @GetMapping("/list")
    public List<Item> list(){
        return serv.findAll();
    }

    @HystrixCommand(fallbackMethod = "alternativeMethod")
    @GetMapping("/detail/{id}/quantity/{quantity}")
    public Item detail(@PathVariable Long id, @PathVariable Integer quantity){
        return serv.findById(id, quantity);
    }

    public Item alternativeMethod(Long id, Integer quantity)
    {
        Item item = new Item();

        Product product = new Product();

         item.setQuantity(quantity);
         product.setId(id);
         product.setName("SOny");
         product.setPrice(500.545);
         item.setProduct(product);

         return item;
    }
}
