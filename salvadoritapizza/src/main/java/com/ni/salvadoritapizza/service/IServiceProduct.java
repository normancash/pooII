package com.ni.salvadoritapizza.service;

import com.ni.salvadoritapizza.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IServiceProduct {


    public List<Product> listAll();

    public Product findById(Long id);

    public void deleteById(Long id);

    public Product insertProduct(Product product);

    public Product updateProduct(Product product);

    public List<Product> listProduct();

    public List<Product> listExtra();

}
