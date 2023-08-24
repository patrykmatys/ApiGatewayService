package org.thesis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.thesis.models.Cart;
import org.thesis.models.CartRequest;
import org.thesis.services.cart.CartService;

@RestController
@RequestMapping("/api/v1/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @PostMapping("/add")
    public ResponseEntity<Cart> addToCart(@RequestBody CartRequest cartRequest) {
        return cartService.addToCart(cartRequest);
    }

    @PostMapping("/remove")
    public ResponseEntity<Cart> removeFromCart(@RequestBody CartRequest cartRequest) {
        return cartService.removeFromCart(cartRequest);
    }

    @GetMapping("/{user}")
    public ResponseEntity<Cart> getCart(@PathVariable String user) {
        return cartService.getCart(user);
    }

    @PostMapping("/remove/{user}")
    public ResponseEntity<Cart> emptyCart(@PathVariable String user) {
        return cartService.emptyCart(user);
    }
}