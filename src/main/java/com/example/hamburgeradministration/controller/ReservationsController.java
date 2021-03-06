package com.example.hamburgeradministration.controller;


import com.example.hamburgeradministration.model.Reservation;
import com.example.hamburgeradministration.service.ReservationsService;
import lombok.extern.log4j.Log4j2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reservations")
@Log4j2
public class ReservationsController {

    @Autowired
    ReservationsService reservationsService;

    @PostMapping
    public ResponseEntity makeReservation(@RequestBody Reservation reservation){
        return reservationsService.makeReservation(reservation);
    }

    @GetMapping
    public ResponseEntity<?> getReservation(){
        return reservationsService.getReservation();
    }

    @GetMapping("/{reservationId}")
    public ResponseEntity<?> getReservation(@PathVariable String reservationId ){
        return reservationsService.getReservation(reservationId);
    }

    @PutMapping("/{reservationId}")
    public ResponseEntity updateReservation(@PathVariable String reservationId ,@RequestBody Reservation reservation){
        return reservationsService.updateReservation(reservationId,reservation);
    }

    @DeleteMapping("/{reservationId}")
    public ResponseEntity deleteReservation(@PathVariable String reservationId ){
        return reservationsService.deleteReservation(reservationId);
    }
}
