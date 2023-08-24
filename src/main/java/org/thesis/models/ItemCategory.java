package org.thesis.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
public class ItemCategory {
    private Long id;
    private Item item;
    private Category category;
}