package com.example.hamburgeradministration.service;

import com.example.hamburgeradministration.model.Reservation;
import com.example.hamburgeradministration.repository.ReservationsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservationsService {
    private static final Logger LOGGER= LoggerFactory.getLogger(ReservationsService.class);

    @Autowired
    ReservationsRepository reservationsRepository;

    public ResponseEntity makeReservation(Reservation reservation) {
        if(reservationsRepository.findByReservationId(reservation.getReservationId()) != null){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        reservationsRepository.save(reservation);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

    public ResponseEntity<?> getReservation() {
        List<Reservation> reservationList =  reservationsRepository.findAll();
        List<Reservation> sortedReservationList = reservationList.stream().sorted(Comparator.comparing(Reservation::getDate)).collect(Collectors.toList());
        return new ResponseEntity<>(sortedReservationList,HttpStatus.OK);
    }

    public ResponseEntity updateReservation(String reservationId, Reservation reservation) {
        Reservation reservationEntry = reservationsRepository.findByReservationId(reservationId);
        if(reservationEntry==null) {
            return new ResponseEntity((HttpStatus.NOT_FOUND));
        }
        reservationEntry.setFirstName(reservation.getFirstName());
        reservationEntry.setLastName(reservation.getLastName());
        reservationEntry.setDate(reservation.getDate());
        reservationsRepository.deleteByReservationId(reservationId);
        reservationsRepository.save(reservationEntry);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public ResponseEntity deleteReservation(String reservationId) {
        Reservation reservationEntry =  reservationsRepository.findByReservationId(reservationId);
        if(reservationEntry != null){
            reservationsRepository.deleteByReservationId(reservationId);
            return  new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<?> getReservation(String reservationId) {
        Reservation reservationEntry =  reservationsRepository.findByReservationId(reservationId);
        if(reservationEntry==null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(reservationEntry, HttpStatus.OK);
    }
}
