package com.reservibe.domain.entity.reservation;

import com.reservibe.domain.entity.client.Client;
import com.reservibe.domain.entity.restaurant.Restaurant;
import com.reservibe.domain.entity.table.Table;
import com.reservibe.domain.enums.reservation.ReservationStatus;
import com.reservibe.domain.input.reservation.CreateReservationInput;
import com.reservibe.infra.model.table.TableModel;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class Reservation {

    private UUID id;
    private Client client;
    private ReservationStatus status;
    private LocalDateTime reservationDate;
    private TableModel table;
    private String notesObservations;

    public Reservation(UUID id, Client client, ReservationStatus status, LocalDateTime reservationDate, TableModel table, String notesObservations) {
        this.id = id;
        this.client = client;
        this.status = status;
        this.reservationDate = reservationDate;
        this.table = table;
        this.notesObservations = notesObservations;
    }

    @Deprecated(since = "Only for framework use")
    public Reservation() {}

    public Reservation(Client client, ReservationStatus status, LocalDateTime reservationDate, TableModel table, String notesObservations) {

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

    public TableModel getTables() {
        return table;
    }

    public String getNotesObservations() {
        return notesObservations;
    }

}
