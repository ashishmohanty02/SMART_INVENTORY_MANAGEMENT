package com.example.pratice1.ControllerLayer;

import com.example.pratice1.Entity.Orders;
import com.example.pratice1.ServiceLayer.Orders.OrdersImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Orders")
public class OrdersController {
    @Autowired
    private OrdersImpl ordersImpl;
    @PostMapping("/{supplierId}")
    public ResponseEntity<Orders> saveOrders(@PathVariable long supplierId,@RequestBody Orders orders){
        return new ResponseEntity<Orders>(ordersImpl.saveOrders(orders,supplierId), HttpStatus.CREATED);
    }
    @PutMapping("/{orderId}/{supplierId}")
    public ResponseEntity<Orders> addSuuplierDetailsToOrders(@PathVariable long orderId,@PathVariable long supplierId){
        return new ResponseEntity<Orders>(ordersImpl.addSupplierOrders(orderId,supplierId),HttpStatus.CREATED);
    }
    @GetMapping("")
    public ResponseEntity<List<Orders>> sendAllOrderDetails(){
        return new ResponseEntity<List<Orders>>(ordersImpl.sendAllOrders(),HttpStatus.OK);
    }
    @GetMapping("/{orderId}")
    public ResponseEntity<Optional<Orders>> sendOrderById(@PathVariable long orderId){
        return new ResponseEntity<Optional<Orders>>(ordersImpl.findOrderById(orderId),HttpStatus.FOUND);
    }
    @PutMapping("/{orderId}")
    public ResponseEntity<Orders> updateOrderDetails(@RequestBody Orders orders,@PathVariable long orderId){
        return new ResponseEntity<Orders>(ordersImpl.updateOrder(orders,orderId),HttpStatus.OK);
    }
    @DeleteMapping("/{orderId}")
    public ResponseEntity<Boolean> deleteOrderDetails(@PathVariable long orderId){
        return new ResponseEntity<Boolean>(ordersImpl.deleteOrder(orderId),HttpStatus.GONE);
    }
}
