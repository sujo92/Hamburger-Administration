package com.example.hamburgeradministration.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "menu")
@Data
public class Menu {
    @Id
    private String id;
    private String name;
    private String price;
    private boolean isCombo;
    private String comboPrice;
    private String category;
}
