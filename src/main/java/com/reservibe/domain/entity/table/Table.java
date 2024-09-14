package com.reservibe.domain.entity.table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.reservibe.domain.entity.restaurant.Restaurant;
import com.reservibe.domain.enums.table.TableStatus;

import java.util.UUID;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Table {

    private UUID id;
    private Integer number;
    private int seats;
    private TableStatus status;
    private Restaurant restaurant;

    public Table(UUID id, Integer number, int seats, TableStatus status, Restaurant restaurant) {
        this.id = id;
        this.number = number;
        this.seats = seats;
        this.status = status;
        this.restaurant = restaurant;
    }

    public Table(Integer number, int seats, TableStatus status) {
        this.number = number;
        this.seats = seats;
        this.status = status;
    }

    public Table(UUID id, Integer number, int seats, TableStatus status) {
        this.id = id;
        this.number = number;
        this.seats = seats;
        this.status = status;
    }

    public UUID getId() {
        return id;
    }

    public int getNumber() {
        return number;
    }

    public int getSeats() {
        return seats;
    }

    public TableStatus getStatus() {
        return status;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }
}
