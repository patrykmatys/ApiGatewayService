package org.thesis.services.order;

import org.springframework.http.ResponseEntity;
import org.thesis.models.OrderHistory;

public interface OrderService {
    ResponseEntity<OrderHistory> addOrder(String user);
    ResponseEntity<OrderHistory> getOrderHistory(String user);
}
