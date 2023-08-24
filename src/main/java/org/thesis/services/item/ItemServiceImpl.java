package org.thesis.services.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.thesis.models.Item;

import java.util.Optional;
import java.util.UUID;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private String itemsServiceUrl;

    @Override
    public Item getItemById(UUID id) {
        String url = itemsServiceUrl + "/" + id;
        return restTemplate.getForEntity(url, Item.class).getBody();
    }

    @Override
    public Iterable<Item> getItems() {
        return restTemplate.getForEntity(itemsServiceUrl, Iterable.class).getBody();
    }

    @Override
    public Iterable<Item> getItemsByCategoryId(UUID id) {
        String url = itemsServiceUrl + "/category/" + id;
        return restTemplate.getForEntity(url, Iterable.class).getBody();
    }
}
