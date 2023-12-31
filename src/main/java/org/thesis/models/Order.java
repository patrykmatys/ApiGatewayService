package org.thesis.models;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class Order {
    private Cart cart;
    private Date created;
    private BigDecimal price;
}
