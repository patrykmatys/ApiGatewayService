package org.thesis.models;

import lombok.Data;

import java.util.List;

@Data
public class OrderHistory {
    private String user;
    private List<Order> orders;
}
