package com.ni.salvadoritapizza.controller;


import com.ni.salvadoritapizza.model.Product;
import com.ni.salvadoritapizza.service.IServiceProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@CrossOrigin("*")
public class ControllerProduct {
    @Autowired
    private IServiceProduct serviceProduct;

    @GetMapping("/all")
    public List<Product> getAll() {
        return serviceProduct.listAll();
    }

    @GetMapping("/listProduct")
    public List<Product> getProductAll() {
        return serviceProduct.listProduct();
    }

    @GetMapping("/listExtra")
    public List<Product> getExtraAll() {
        return serviceProduct.listExtra();
    }

    @GetMapping("/findById/{id}")
    public Product findById(@PathVariable Long id) {
        return serviceProduct.findById(id);
    }

    @PostMapping("/insert")
    public Product insertProduct(@RequestBody Product product) {
        return serviceProduct.insertProduct(product);
    }

    @PostMapping("/update")
    public Product updateProduct(@RequestBody Product product) {
        return serviceProduct.updateProduct(product);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProduct(@PathVariable Long id){
        serviceProduct.deleteById(id);
    }
}
