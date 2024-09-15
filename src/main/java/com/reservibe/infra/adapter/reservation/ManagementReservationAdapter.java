package com.reservibe.infra.adapter.reservation;

import com.reservibe.domain.entity.reservation.Reservation;
import com.reservibe.domain.entity.table.Table;
import com.reservibe.domain.enums.reservation.ReservationStatus;
import com.reservibe.domain.enums.table.TableStatus;
import com.reservibe.infra.model.reservation.ReservationModel;
import com.reservibe.infra.model.table.TableModel;
import com.reservibe.infra.repository.reservation.ReservationRepository;
import jakarta.persistence.EntityNotFoundException;

import java.util.UUID;

public class ManagementReservationAdapter {
    private final ReservationRepository reservationRepository;

    public ManagementReservationAdapter(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public Reservation findById(UUID id) {
        var reservation = reservationRepository.findById(id)
                .orElseThrow(()->new EntityNotFoundException("Table not Available"));
        var table = new Table(reservation.getTable().getId(),
                reservation.getTable().getNumber(),
                reservation.getTable().getSeats(),
                reservation.getTable().getStatus());

        return new Reservation(reservation.getId(),
                reservation.getClient(),
                reservation.getStatus(),
                reservation.getReservationDate(),
                table,
                reservation.getNotesObservations());
    }

    public void updateReserver(Reservation reserv) {

        var tableModel = new TableModel(reserv.getTable().getId(),
                reserv.getTable().getNumber(),
                reserv.getTable().getSeats(),
                reserv.getTable().getStatus());

        this.reservationRepository.save(new ReservationModel(
                reserv.getId(),
                reserv.getClient(),
                reserv.getStatus(),
                reserv.getReservationDate(),
                tableModel,
                reserv.getNotesObservations()));
    }
}
