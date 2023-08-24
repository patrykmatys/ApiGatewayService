package org.thesis.services.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.thesis.models.OrderHistory;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private String orderServiceUrl;

    @Override
    public ResponseEntity<OrderHistory> addOrder(String user) {
        String url = orderServiceUrl + "/add/" + user;
        return restTemplate.postForEntity(url, null, OrderHistory.class);
    }

    @Override
    public ResponseEntity<OrderHistory> getOrderHistory(String user) {
        String url = orderServiceUrl + "/" + user;
        return restTemplate.getForEntity(url, OrderHistory.class);
    }
}
