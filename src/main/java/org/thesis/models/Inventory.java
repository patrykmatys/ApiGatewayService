package org.thesis.models;

import lombok.Data;

@Data
public class Inventory {

    private Long id;
    private Item item;
    private int quantity;
    private String location;
}