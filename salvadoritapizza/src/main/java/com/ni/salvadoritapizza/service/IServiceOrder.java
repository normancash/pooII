package com.ni.salvadoritapizza.service;

import com.ni.salvadoritapizza.dto.OrderDTO;
import com.ni.salvadoritapizza.model.ORDERSTATUS;
import com.ni.salvadoritapizza.model.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IServiceOrder {

    public List<Order> getAll();

    public Order findById(Long id);

    public Order save(OrderDTO orderDTO);

    public void delete(Long id);

    public Order updateStatus(Long id,ORDERSTATUS orderstatus);
    public List<Order> listByStatus(ORDERSTATUS orderstatuses);

}
