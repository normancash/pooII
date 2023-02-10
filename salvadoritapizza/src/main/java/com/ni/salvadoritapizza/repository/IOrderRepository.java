package com.ni.salvadoritapizza.repository;


import com.ni.salvadoritapizza.model.ORDERSTATUS;
import com.ni.salvadoritapizza.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IOrderRepository extends JpaRepository<Order,Long> {

    @Query("select e from Order e where e.orderStatus = :orderstatus")
    public List<Order> getByStatus(ORDERSTATUS orderstatus);
}
