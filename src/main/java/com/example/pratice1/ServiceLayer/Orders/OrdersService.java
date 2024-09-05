package com.example.pratice1.ServiceLayer.Orders;

import com.example.pratice1.Entity.Orders;
import com.example.pratice1.Entity.Supplier;
import com.example.pratice1.Repository.OrdersRepo;
import com.example.pratice1.Repository.SupplierRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrdersService implements OrdersImpl{
    @Autowired
    private SupplierRepo supplierRepo;

    @Autowired
    private OrdersRepo ordersRepo;
    @Override
    public Orders saveOrders(Orders orders,long supplierId) {
        if(supplierId>0){
            Supplier supplier=supplierRepo.findById(supplierId).orElse(null);
            orders.setSupplier(supplier);
        }
        return ordersRepo.save(orders);
    }

    @Override
    public Orders addSupplierOrders(long orderId,long supplierId) {

        Orders orders=ordersRepo.findById(orderId).orElseThrow(null);
        Supplier supplier=supplierRepo.findById(supplierId).orElseThrow(null);
        orders.setSupplier(supplier);
        return ordersRepo.save(orders);
    }

    @Override
    public List<Orders> sendAllOrders() {
        return ordersRepo.findAll();
    }

    @Override
    public Optional<Orders> findOrderById(long orderId) {
        if(ordersRepo.existsById(orderId))
            return ordersRepo.findById(orderId);
        return null;
    }

    @Override
    public Orders updateOrder(Orders orders,long orderId) {
        Orders orders1=ordersRepo.findById(orderId).orElseThrow(null);
        orders1.setOrderDate(orders.getOrderDate());
        orders1.setDeliveryDate(orders.getDeliveryDate());
        return null;
    }

    @Override
    public Boolean deleteOrder(long orderId) {
        Orders orders=ordersRepo.findById(orderId).orElseThrow(null);
        ordersRepo.deleteById(orderId);
        if(ordersRepo.existsById(orderId))
            return false;
        return true;
    }
}
