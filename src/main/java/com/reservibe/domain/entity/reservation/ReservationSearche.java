package com.reservibe.domain.entity.reservation;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.reservibe.domain.entity.client.Client;
import com.reservibe.domain.enums.reservation.ReservationStatus;

import java.time.LocalDateTime;
import java.util.UUID;
@JsonInclude(JsonInclude.Include.NON_NULL)

public class ReservationSearche {

    private UUID id;
    private Client client;
    private ReservationStatus status;
    private LocalDateTime reservationDate;
    private String notesObservations;

    public ReservationSearche(UUID id, Client client, ReservationStatus status, LocalDateTime reservationDate,  String notesObservations) {
        this.id = id;
        this.client = client;
        this.status = status;
        this.reservationDate = reservationDate;
        this.notesObservations = notesObservations;
    }

    @Deprecated(since = "Only for framework use")
    public ReservationSearche() {}

    public ReservationSearche(Client client, ReservationStatus status, LocalDateTime reservationDate,  String notesObservations) {

        this.client = client;
        this.status = status;
        this.reservationDate = reservationDate;
        this.notesObservations = notesObservations;
    }



    public UUID getId() {
        return id;
    }

    public Client getClient() {
        return client;
    }

    public ReservationStatus getStatus() {
        return status;
    }

    public LocalDateTime getReservationDate() {
        return reservationDate;
    }


    public String getNotesObservations() {
        return notesObservations;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}

