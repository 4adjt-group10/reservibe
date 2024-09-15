package com.reservibe.infra.model.reservation;

import com.reservibe.domain.entity.client.Client;
import com.reservibe.domain.enums.reservation.ReservationStatus;
import com.reservibe.infra.model.table.TableModel;
import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class ReservationModel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb")
    private Client client;
    @Enumerated(EnumType.STRING)
    private ReservationStatus status;
    private LocalDateTime reservationDate;
    @ManyToOne()
    @JoinColumn(name = "table_id")
    private TableModel table;
    private String notesObservations;


    public ReservationModel() {}

    public ReservationModel(UUID id,
                            Client client,
                            ReservationStatus status,
                            LocalDateTime reservationDate,
                            TableModel table,
                            String notesObservations) {
        this.id = id;
        this.client = client;
        this.status = status;
        this.reservationDate = reservationDate;
        this.table = table;
        this.notesObservations = notesObservations;
    }


    public ReservationModel(Client client,
                            ReservationStatus status,
                            LocalDateTime reservationDate,
                            TableModel table,
                            String notesObservations) {
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

    public TableModel getTable() {
        return table;
    }

    public String getNotesObservations() {
        return notesObservations;
    }

    public void setTable(TableModel tableModel) {
        this.table = tableModel;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setStatus(ReservationStatus status) {
        this.status = status;
    }
}

