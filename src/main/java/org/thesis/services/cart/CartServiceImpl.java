package org.thesis.services.cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.thesis.models.CartRequest;
import org.thesis.models.SimpleCart;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private String cartServiceUrl;
    @Override
    public ResponseEntity<SimpleCart> addToCart(CartRequest cartRequest) {
        String url = cartServiceUrl + "/add";
        return restTemplate.postForEntity(url, cartRequest, SimpleCart.class);
    }

    @Override
    public ResponseEntity<SimpleCart> getCart(String user) {
        String url = cartServiceUrl + "/" + user;
        return restTemplate.getForEntity(url, SimpleCart.class);
    }

    @Override
    public ResponseEntity<SimpleCart> removeFromCart(CartRequest cartRequest) {
        String url = cartServiceUrl + "/remove";
        return restTemplate.postForEntity(url, cartRequest, SimpleCart.class);
    }

    @Override
    public ResponseEntity<SimpleCart> emptyCart(String user) {
        String url = cartServiceUrl + "/remove/" + user;
        return restTemplate.postForEntity(url, null, SimpleCart.class);
    }
}

