package com.example.pratice1.ServiceLayer.OrdersItemService;

import com.example.pratice1.Entity.OrderItem;
import com.example.pratice1.Entity.Orders;
import com.example.pratice1.Entity.Product;
import com.example.pratice1.Entity.WareHouse;
import com.example.pratice1.Repository.OrderItemRepo;
import com.example.pratice1.Repository.OrdersRepo;
import com.example.pratice1.Repository.ProductRepo;
import com.example.pratice1.Repository.WareHouseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderItemService implements OrderItemImpl{

    @Autowired
    private WareHouseRepo wareHouseRepo;

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private OrdersRepo ordersRepo;

    @Autowired
    private OrderItemRepo orderItemRepo;
    @Override
    public OrderItem saveOrderItem(OrderItem orderItem,long orderId,long productId,long wareHouseId) {
        if(orderId>0){
            Orders orders=ordersRepo.findById(orderId).orElseThrow(null);

                orderItem.setOrder(orders);

        }
        if(productId>0){
            Product product=productRepo.findById(productId).orElseThrow(null);

            orderItem.setProduct(product);

        }
        if(wareHouseId>0){
            WareHouse wareHouse=wareHouseRepo.findById(wareHouseId).orElseThrow(null);

            orderItem.setWareHouse(wareHouse);

        }

        return orderItemRepo.save(orderItem);
    }

    @Override
    public OrderItem updateOrderItem(OrderItem orderItem,long orderItemId) {
        OrderItem orderItem1=orderItemRepo.findById(orderItemId).orElseThrow(null);
        orderItem1.setOrderItemQty(orderItem.getOrderItemQty());
        return orderItemRepo.save(orderItem1);
    }

    @Override
    public Boolean deleteOrderItem(long orderItemId) {
        if(orderItemRepo.existsById(orderItemId))
            orderItemRepo.deleteById(orderItemId);
        if(orderItemRepo.existsById(orderItemId))
            return false;
        return true;
    }
}
