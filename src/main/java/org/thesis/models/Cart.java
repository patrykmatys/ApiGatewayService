package org.thesis.models;

import lombok.Data;

import java.util.HashMap;
import java.util.UUID;

@Data
public class Cart {
    private String user;
    private HashMap<UUID, Integer> items;
}
