package com.ni.salvadoritapizza.service;

import com.ni.salvadoritapizza.model.Product;
import com.ni.salvadoritapizza.model.TYPEPRODUCT;
import com.ni.salvadoritapizza.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceProduct implements IServiceProduct{

    @Autowired
    private IProductRepository repositoryProduct;

    @Override
    public List<Product> listAll() {
        return repositoryProduct.findAll();
    }

    @Override
    public Product findById(Long id) {
        return repositoryProduct.findById(id).get();
    }

    @Override
    public void deleteById(Long id) {
        repositoryProduct.deleteById(id);
    }

    @Override
    public Product insertProduct(Product product) {
        return repositoryProduct.save(product);
    }

    @Override
    public Product updateProduct(Product product) {
        return repositoryProduct.save(product);
    }

    @Override
    public List<Product> listProduct() {
        return repositoryProduct.listProduct(TYPEPRODUCT.PIZZA);
    }

    @Override
    public List<Product> listExtra() {
        return repositoryProduct.listProduct(TYPEPRODUCT.EXTRA);
    }
}
