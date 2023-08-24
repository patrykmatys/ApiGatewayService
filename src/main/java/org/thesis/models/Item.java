package org.thesis.models;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;


@Data
public class Item {
    private UUID id;
    private String name;
    private BigDecimal price;
    private Date created;
    private Date updated;
    private List<Category> category;
}
