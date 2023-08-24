package org.thesis.services.cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.thesis.models.Cart;
import org.thesis.models.CartRequest;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private String cartServiceUrl;
    @Override
    public ResponseEntity<Cart> addToCart(CartRequest cartRequest) {
        String url = cartServiceUrl + "/add";
        return restTemplate.postForEntity(url, cartRequest, Cart.class);
    }

    @Override
    public ResponseEntity<Cart> getCart(String user) {
        String url = cartServiceUrl + "/" + user;
        return restTemplate.getForEntity(url, Cart.class);
    }

    @Override
    public ResponseEntity<Cart> removeFromCart(CartRequest cartRequest) {
        String url = cartServiceUrl + "/remove";
        return restTemplate.postForEntity(url, cartRequest, Cart.class);
    }

    @Override
    public ResponseEntity<Cart> emptyCart(String user) {
        String url = cartServiceUrl + "/remove/" + user;
        return restTemplate.postForEntity(url, null, Cart.class);
    }
}

