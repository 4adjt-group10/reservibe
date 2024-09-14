package com.reservibe.domain.entity.reservation;

import com.reservibe.domain.entity.client.Client;
import com.reservibe.domain.entity.table.Table;
import com.reservibe.domain.enums.reservation.ReservationStatus;

import java.time.LocalDateTime;
import java.util.UUID;

public class Reservation {

    private UUID id;
    private Client client;
    private ReservationStatus status;
    private LocalDateTime reservationDate;
    private Table table;
    private String notesObservations;

    public Reservation(UUID id, Client client, ReservationStatus status, LocalDateTime reservationDate, Table table, String notesObservations) {
        this.id = id;
        this.client = client;
        this.status = status;
        this.reservationDate = reservationDate;
        this.table = table;
        this.notesObservations = notesObservations;
    }

    @Deprecated(since = "Only for framework use")
    public Reservation() {}

    public Reservation(Client client, ReservationStatus status, LocalDateTime reservationDate, Table table, String notesObservations) {

        this.client = client;
        this.status = status;
        this.reservationDate = reservationDate;
        this.table = table;
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

    public Table getTable() {
        return table;
    }

    public String getNotesObservations() {
        return notesObservations;
    }

}
