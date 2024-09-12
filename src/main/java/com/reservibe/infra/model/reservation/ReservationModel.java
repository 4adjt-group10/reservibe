package com.reservibe.infra.model.reservation;

import com.reservibe.domain.enums.reservation.ReservationStatus;
import com.reservibe.infra.model.client.ClientModel;
import com.reservibe.infra.model.restaurant.RestaurantModel;
import com.reservibe.infra.model.table.TableModel;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
public class ReservationModel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @ManyToOne
    private ClientModel client;
    @Enumerated(EnumType.STRING)
    private ReservationStatus status;
    private LocalDateTime reservationDate;
    @OneToMany
    @JoinColumn(name = "reservation_id")
    private List<TableModel> tables;
    private String notesObservations;

    public ReservationModel() {}

    public ReservationModel(UUID id,
                            ClientModel client,
                            ReservationStatus status,
                            LocalDateTime reservationDate,
                            List<TableModel> tables,
                            String notesObservations) {
        this.id = id;
        this.client = client;
        this.status = status;
        this.reservationDate = reservationDate;
        this.tables = tables;
        this.notesObservations = notesObservations;
    }

    public UUID getId() {
        return id;
    }

    public ClientModel getClient() {
        return client;
    }

    public ReservationStatus getStatus() {
        return status;
    }

    public LocalDateTime getReservationDate() {
        return reservationDate;
    }

    public List<TableModel> getTables() {
        return tables;
    }

    public String getNotesObservations() {
        return notesObservations;
    }

}

