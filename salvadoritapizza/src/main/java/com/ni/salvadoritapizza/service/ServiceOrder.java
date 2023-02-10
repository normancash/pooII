package com.ni.salvadoritapizza.service;


import com.ni.salvadoritapizza.dto.DetailDTO;
import com.ni.salvadoritapizza.dto.DetailOrderDTO;
import com.ni.salvadoritapizza.dto.OrderDTO;
import com.ni.salvadoritapizza.model.Detail;
import com.ni.salvadoritapizza.model.DetailOrder;
import com.ni.salvadoritapizza.model.ORDERSTATUS;
import com.ni.salvadoritapizza.model.Order;
import com.ni.salvadoritapizza.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceOrder implements IServiceOrder{
    @Autowired
    private IOrderRepository orderRepository;

    @Autowired
    private IClientRepository clientRepository;

    @Autowired
    private IBranchRepository branchRepository;

    @Autowired
    private IDetailOrderRepository detailOrderRepository;

    @Autowired
    private IDetailRepository detailRepository;

    @Autowired
    private IProductRepository productRepository;

    @Override
    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order findById(Long id) {
        return orderRepository.findById(id).get();
    }

    @Override
    public Order save(OrderDTO orderDTO) {
        Order order = null;
        if (orderDTO.getId() == null) {
            order = new Order();
        }
        else {
            order = orderRepository.findById(orderDTO.getId()).get();
        }
        order.setDateOrder(orderDTO.getDateOrder());
        order.setTotal(orderDTO.getTotal());
        order.setOrderStatus(orderDTO.getOrderstatus());
        order.setClient(clientRepository.findById(orderDTO.getIdClient()).get());
        order.setBranch(branchRepository.findById(orderDTO.getIdBranch()).get());
        //Detail
        for (DetailOrderDTO detail : orderDTO.getDetalles()) {
            DetailOrder detailOrder = null;
            if (detail.getId() == null) {
                detailOrder= new DetailOrder();
            }
            else {
                detailOrder = detailOrderRepository.findById(detail.getId()).get();
            }
            detailOrder.setProduct(productRepository.findById(detail.getIdProduct()).get());
            detailOrder.setQuantity(detail.getQuantity());
            if (detail.getDetailExtra() != null) {
                for (DetailDTO detail1 : detail.getDetailExtra()) {
                    Detail det = null;
                    if (detail1.getId() == null) {
                        det = new Detail();
                    } else {
                        det = detailRepository.findById(detail1.getId()).get();
                    }
                    det.setQuantity(detail1.getQuantity());
                    det.setProduct(productRepository.findById(detail1.getIdProducto()).get());
                    det.setDetalleOrder(detailOrder);
                    detailOrder.getDetalles().add(det);
                }
            }
            detailOrder.setOrder(order);
            order.getDetalles().add(detailOrder);
        }
        return orderRepository.save(order);
    }

    @Override
    public void delete(Long id) {
        orderRepository.deleteById(id);
    }

    @Override
    public Order updateStatus(Long id,ORDERSTATUS orderstatus) {
        Order order = orderRepository.findById(id).get();
        if (order !=null) {
            order.setOrderStatus(orderstatus);
            orderRepository.save(order);
            return order;
        }
        return null;
    }

    @Override
    public List<Order> listByStatus(ORDERSTATUS orderstatuses) {
        return orderRepository.getByStatus(orderstatuses);
    }
}
