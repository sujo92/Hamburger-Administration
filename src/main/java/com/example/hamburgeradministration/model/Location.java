package com.example.hamburgeradministration.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "locations")
@Data
public class Location {
    @Id
    private String locationId;
    private String name;
    private String latitude;
    private String longitude;
    private String address;
    private String phone;
}
