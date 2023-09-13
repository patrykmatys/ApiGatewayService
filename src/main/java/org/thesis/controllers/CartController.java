package org.thesis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.thesis.models.CartRequest;
import org.thesis.models.SimpleCart;
import org.thesis.services.cart.CartService;
import org.thesis.services.user.UserService;

@RestController
@RequestMapping("/api/v1/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public ResponseEntity<SimpleCart> addToCart(@RequestBody CartRequest cartRequest,
                                                @RequestHeader("Authorization") String token) {
        if (userService.validateToken(token)) {
            return cartService.addToCart(cartRequest);
        } else {
            return ResponseEntity.status(403).build();
        }
    }

    @PostMapping("/remove")
    public ResponseEntity<SimpleCart> removeFromCart(@RequestBody CartRequest cartRequest,
                                                     @RequestHeader("Authorization") String token) {
        if (userService.validateToken(token)) {
            return cartService.removeFromCart(cartRequest);
        } else {
            return ResponseEntity.status(403).build();
        }
    }

    @PostMapping("/update")
    public ResponseEntity<SimpleCart> updateItemInCart(@RequestBody CartRequest cartRequest,
                                                     @RequestHeader("Authorization") String token) {
        if (userService.validateToken(token)) {
            return cartService.updateItemInCart(cartRequest);
        } else {
            return ResponseEntity.status(403).build();
        }
    }

    @GetMapping("/{user}")
    public ResponseEntity<SimpleCart> getCart(@PathVariable String user,
                                              @RequestHeader("Authorization") String token) {
        if (userService.validateToken(token)) {
            return cartService.getCart(user);
        } else {
            return ResponseEntity.status(403).build();
        }
    }

    @PostMapping("/remove/{user}")
    public ResponseEntity<SimpleCart> emptyCart(@PathVariable String user,
                                                @RequestHeader("Authorization") String token) {
        if (userService.validateToken(token)) {
            return cartService.emptyCart(user);
        } else {
            return ResponseEntity.status(403).build();
        }
    }
}