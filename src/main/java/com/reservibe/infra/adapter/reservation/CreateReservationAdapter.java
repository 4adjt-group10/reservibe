package com.reservibe.infra.adapter.reservation;

import com.reservibe.domain.entity.reservation.Reservation;
import com.reservibe.domain.enums.reservation.ReservationStatus;
import com.reservibe.infra.model.reservation.ReservationModel;
import com.reservibe.infra.model.table.TableModel;
import com.reservibe.infra.repository.reservation.ReservationRepository;

public class CreateReservationAdapter {

    private final ReservationRepository reservationRepository;

    public CreateReservationAdapter(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;

    }

    public void createReservation(Reservation reservation) {
        var tableModel = new TableModel(reservation.getTable().getId(),
                reservation.getTable().getNumber(),
                reservation.getTable().getSeats(),
                reservation.getTable().getStatus());

        this.reservationRepository.save(new ReservationModel(reservation.getClient(),
                ReservationStatus.PENDING,
                reservation.getReservationDate(),
                tableModel,
                reservation.getNotesObservations()));

    }
}
