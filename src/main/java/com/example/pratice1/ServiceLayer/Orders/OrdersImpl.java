package com.example.pratice1.ServiceLayer.Orders;

import com.example.pratice1.Entity.Orders;

import java.util.List;
import java.util.Optional;

public interface OrdersImpl {

    Orders saveOrders(Orders orders,long supplierId);

    Orders addSupplierOrders(long orderId,long supplierId);

    List<Orders> sendAllOrders();

    Optional<Orders> findOrderById(long orderId);

    Orders updateOrder(Orders orders,long orderId);

    Boolean deleteOrder(long orderId);
}
