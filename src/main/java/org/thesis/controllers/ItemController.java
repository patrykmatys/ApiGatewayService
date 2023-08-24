package org.thesis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thesis.models.Item;
import org.thesis.services.item.ItemService;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/items")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @GetMapping("/{id}")
    public Item getItemById(@PathVariable UUID id) {
        return itemService.getItemById(id);
    }

    @GetMapping()
    public Iterable<Item> getItems() {
        return itemService.getItems();
    }

    @GetMapping("/category/{id}")
    public Iterable<Item> getItemsByCategory(@PathVariable UUID id) {
        return itemService.getItemsByCategoryId(id);
    }
}
