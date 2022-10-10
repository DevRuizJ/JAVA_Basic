package com.udemy.productservice.Controller;

import com.udemy.productservice.Entity.Product;
import com.udemy.productservice.Service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ProductController {

    @Autowired
    private Environment env;

    @Value("${server.port}")
    private Integer port;

    @Autowired
    private IProductService serv;

    @GetMapping("/list")
    public List<Product> list(){

        return serv.findALl().stream().map(product -> {

            product.setPort(Integer.parseInt(env.getProperty("local.server.port")));
            //product.setPort(port);

            return product;
        }).collect(Collectors.toList());

    }

    @GetMapping("/detail/{id}")
    public Product detail(@PathVariable Long id){

        Product product = serv.findById(id);
        product.setPort(Integer.parseInt(env.getProperty("local.server.port")));
        //product.setPort(port);
/*
        boolean ok = false;

        if (!ok)
            throw new RuntimeException("Can´t charge to product");
*/
        /*
        try {
            Thread.sleep(2000L);
        }
        catch (InterruptedException ie){
            ie.printStackTrace();
        }
*/
        return product;

    }
}
