package com.reservibe.domain.entity.reservation;

import com.reservibe.domain.entity.client.Client;
import com.reservibe.domain.entity.restaurant.Restaurant;
import com.reservibe.domain.entity.table.Table;
import com.reservibe.domain.enums.reservation.ReservationStatus;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class Reservation {

    private UUID id;
    private Client client;
    private ReservationStatus status;
    private LocalDateTime reservationDate;
    private List<Table> tables;
    private String notesObservations;
    private Restaurant restaurant;

    public Reservation(UUID id, Client client, ReservationStatus status, LocalDateTime reservationDate, List<Table> tables, String notesObservations, Restaurant restaurant) {
        this.id = id;
        this.client = client;
        this.status = status;
        this.reservationDate = reservationDate;
        this.tables = tables;
        this.notesObservations = notesObservations;
        this.restaurant = restaurant;
    }

    @Deprecated(since = "Only for framework use")
    public Reservation() {}

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

    public List<Table> getTables() {
        return tables;
    }

    public String getNotesObservations() {
        return notesObservations;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }
}
