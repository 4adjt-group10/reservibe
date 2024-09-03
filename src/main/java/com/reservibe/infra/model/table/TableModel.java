package com.reservibe.infra.model.table;

import com.reservibe.domain.enums.table.TableStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class TableModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private Integer number;
    private int seats;
    private TableStatus status;

    public TableModel(Integer number, int seats, TableStatus status) {
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
}
