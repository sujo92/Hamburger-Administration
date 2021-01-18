package com.example.hamburgeradministration.repository;

import com.example.hamburgeradministration.model.Reservation;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReservationsRepository extends MongoRepository<Reservation,String> {
    Reservation findByReservationId(String id);
    void deleteByReservationId(String id);
}
