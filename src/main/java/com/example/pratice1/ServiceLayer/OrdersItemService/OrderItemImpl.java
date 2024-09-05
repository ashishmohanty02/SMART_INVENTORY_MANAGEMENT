package com.example.pratice1.ServiceLayer.OrdersItemService;

import com.example.pratice1.Entity.OrderItem;

import java.util.List;

public interface OrderItemImpl {

    OrderItem saveOrderItem(OrderItem orderItem,long orderId,long productId,long wareHouseId);

    OrderItem updateOrderItem(OrderItem orderItem,long orderItemId);

    Boolean deleteOrderItem(long orderItemId);
}
