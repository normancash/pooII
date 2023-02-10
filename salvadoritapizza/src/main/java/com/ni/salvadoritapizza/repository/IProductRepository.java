package com.ni.salvadoritapizza.repository;

import com.ni.salvadoritapizza.model.Product;
import com.ni.salvadoritapizza.model.TYPEPRODUCT;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductRepository extends JpaRepository<Product,Long> {

    @Query("select e from Product e where e.typeProduct = :type")
    public List<Product> listProduct(TYPEPRODUCT type);


}
