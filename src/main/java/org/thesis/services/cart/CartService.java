package org.thesis.services.cart;

import org.springframework.http.ResponseEntity;
import org.thesis.models.CartRequest;
import org.thesis.models.SimpleCart;

public interface CartService {
    ResponseEntity<SimpleCart> addToCart(CartRequest cartRequest);
    ResponseEntity<SimpleCart> getCart(String user);
    ResponseEntity<SimpleCart> removeFromCart(CartRequest cartRequest);
    ResponseEntity<SimpleCart> emptyCart(String user);
}
