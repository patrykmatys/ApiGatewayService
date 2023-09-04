package org.thesis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.thesis.models.Item;
import org.thesis.services.item.ItemService;
import org.thesis.services.user.UserService;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/items")
public class ItemController {
    @Autowired
    private ItemService itemService;
    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<Item> getItemById(@PathVariable UUID id,
                            @RequestHeader("Authorization") String token) {
        if (userService.validateToken(token)) {
            return ResponseEntity.status(200).body(itemService.getItemById(id));
        } else {
            return ResponseEntity.status(403).build();
        }

    }

    @GetMapping()
    public ResponseEntity<Iterable<Item>> getItems(@RequestHeader("Authorization") String token) {

        if (userService.validateToken(token)) {
            return ResponseEntity.status(200).body(itemService.getItems());
        } else {
            return ResponseEntity.status(403).build();
        }
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<Iterable<Item>> getItemsByCategory(@PathVariable UUID id,
                                             @RequestHeader("Authorization") String token) {

        if (userService.validateToken(token)) {
            return ResponseEntity.status(200).body(itemService.getItemsByCategoryId(id));
        } else {
            return ResponseEntity.status(403).build();
        }
    }
}
