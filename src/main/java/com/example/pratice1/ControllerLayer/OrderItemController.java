package com.example.pratice1.ControllerLayer;

import com.example.pratice1.Entity.OrderItem;
import com.example.pratice1.ServiceLayer.OrdersItemService.OrderItemImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/OrderItem")
public class OrderItemController {

    @Autowired
    private OrderItemImpl orderItemImpl;

    @PostMapping("/{orderId}/{productId}/{warehouseId}")
    public ResponseEntity<OrderItem> saveOrderItemDetails(@RequestBody OrderItem orderItem, @PathVariable long orderId,@PathVariable long productId,@PathVariable long warehouseId){
        return new ResponseEntity<OrderItem>(orderItemImpl.saveOrderItem(orderItem,orderId,productId,warehouseId), HttpStatus.CREATED);
    }
    @PutMapping("/{orderItemId}")
    public ResponseEntity<OrderItem> updateOrderItemDetails(@RequestBody OrderItem orderItem,@PathVariable long orderItemId){
        return new ResponseEntity<OrderItem>(orderItemImpl.updateOrderItem(orderItem,orderItemId),HttpStatus.OK);
    }
    @DeleteMapping("/{orderItemId}")
    public ResponseEntity<Boolean> deleteOrderItemById(@PathVariable long orderItemId){
        return new ResponseEntity<Boolean>(orderItemImpl.deleteOrderItem(orderItemId),HttpStatus.GONE);
    }
}
