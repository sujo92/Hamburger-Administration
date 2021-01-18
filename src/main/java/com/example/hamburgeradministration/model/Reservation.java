package com.example.hamburgeradministration.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Document(collection = "reservations")
@Data
public class Reservation {
    @Id
    private String reservationId;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yy-MM-dd HH:mm", timezone = "CST")
    private LocalDateTime date;
    private String firstName;
    private String lastName;
}
