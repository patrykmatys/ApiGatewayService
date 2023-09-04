package org.thesis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.thesis.models.OrderHistory;
import org.thesis.services.order.OrderService;
import org.thesis.services.user.UserService;

@RestController
@RequestMapping("/api/v1/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private UserService userService;

    @PostMapping("/add/{user}")
    public ResponseEntity<OrderHistory> addOrder(@PathVariable String user,
                                                 @RequestHeader("Authorization") String token) {
        if (userService.validateToken(token)) {
            return orderService.addOrder(user);
        } else {
            return ResponseEntity.status(403).build();
        }
    }

    @GetMapping("/{user}")
    public ResponseEntity<OrderHistory> getOrders(@PathVariable String user,
                                                  @RequestHeader("Authorization") String token) {
        if (userService.validateToken(token)) {
            return orderService.getOrderHistory(user);
        } else {
            return ResponseEntity.status(403).build();
        }
    }
}