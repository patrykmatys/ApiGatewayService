package org.thesis.models;

import lombok.Data;

import java.util.Date;

@Data
public class Order {
    private Cart cart;
    private Date created;
}
