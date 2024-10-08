package com.reservibe.infra.model.table;

import com.reservibe.domain.enums.table.TableStatus;
import com.reservibe.infra.model.restaurant.RestaurantModel;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class TableModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;
    private Integer number;
    private int seats;
    @Enumerated(EnumType.STRING)
    private TableStatus status;
    @ManyToOne
    @JoinColumn(name = "restaurant_id", nullable = false)
    private RestaurantModel restaurant;

    public TableModel(Integer number, int seats, TableStatus status) {
        this.number = number;
        this.seats = seats;
        this.status = status;
    }

    public TableModel(Integer number,
                      int seats,
                      TableStatus status,
                      RestaurantModel restaurant) {
        this.number = number;
        this.seats = seats;
        this.status = status;
        this.restaurant = restaurant;
    }

    public TableModel(UUID id, Integer number, int seats, TableStatus status) {
        this.id = id;
        this.number = number;
        this.seats = seats;
        this.status = status;
    }

    @Deprecated(since = "Only for framework use")
    public TableModel() {
    }

    public UUID getId() {
        return id;
    }

    public Integer getNumber() {
        return number;
    }

    public int getSeats() {
        return seats;
    }

    public TableStatus getStatus() {
        return status;
    }

    public RestaurantModel getRestaurant() {
        return restaurant;
    }

    public void setStatus(TableStatus tableStatus) {
        this.status = tableStatus;
    }
}
