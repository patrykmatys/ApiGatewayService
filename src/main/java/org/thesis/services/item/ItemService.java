package org.thesis.services.item;

import org.thesis.models.Item;

import java.util.Optional;
import java.util.UUID;

public interface ItemService {
    Item getItemById(UUID id);
    Iterable<Item> getItems();
    Iterable<Item> getItemsByCategoryId(UUID id);
}
