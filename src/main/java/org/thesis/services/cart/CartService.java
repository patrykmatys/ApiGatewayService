package org.thesis.services.cart;

import org.springframework.http.ResponseEntity;
import org.thesis.models.Cart;
import org.thesis.models.CartRequest;

import java.util.UUID;

public interface CartService {
    ResponseEntity<Cart> addToCart(CartRequest cartRequest);
    ResponseEntity<Cart> getCart(String user);
    ResponseEntity<Cart> removeFromCart(CartRequest cartRequest);
    ResponseEntity<Cart> emptyCart(String user);
}
