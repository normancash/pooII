package com.ni.salvadoritapizza.controller;


import com.ni.salvadoritapizza.dto.OrderDTO;
import com.ni.salvadoritapizza.model.ORDERSTATUS;
import com.ni.salvadoritapizza.model.Order;
import com.ni.salvadoritapizza.service.IServiceOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
@CrossOrigin("*")
public class ControllerOrder {

    @Autowired
    private IServiceOrder serviceOrder;

    @GetMapping("/all")
    public List<Order> getAll() {
        return serviceOrder.getAll();
    }

    @GetMapping("/findById/{id}")
    public Order findById(@PathVariable Long id) {
        return serviceOrder.findById(id);
    }

    @PostMapping("/insert")
    public Order insertOrder(@RequestBody OrderDTO orderDTO) {
        return serviceOrder.save(orderDTO);
    }

    @PostMapping("/update")
    public Order updateOrder(@RequestBody OrderDTO orderDTO) {
        return serviceOrder.save(orderDTO);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteOrder(@PathVariable Long id){
        serviceOrder.delete(id);
    }

    @GetMapping("list")
    public List<Order> getOrderStatus(@RequestParam ORDERSTATUS orderStatus){
        return serviceOrder.listByStatus(orderStatus);
    }

    @PostMapping("/updateStatus")
    public Order updateStatus(@RequestParam Long id,@RequestParam ORDERSTATUS orderStatus) {
        return serviceOrder.updateStatus(id,orderStatus);
    }
}
