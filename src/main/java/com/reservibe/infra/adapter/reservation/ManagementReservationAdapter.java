package com.reservibe.infra.adapter.reservation;

import com.reservibe.domain.entity.reservation.Reservation;
import com.reservibe.domain.gateway.reservation.ManagementReservationInterface;
import com.reservibe.infra.model.reservation.ReservationModel;
import com.reservibe.infra.model.table.TableModel;
import com.reservibe.infra.repository.reservation.ReservationRepository;

public class ManagementReservationAdapter implements ManagementReservationInterface {
    private final ReservationRepository reservationRepository;

    public ManagementReservationAdapter(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Override
    public void updateReservation(Reservation reservation) {
        var tableModel = new TableModel(reservation.getTable().getId(),
                reservation.getTable().getNumber(),
                reservation.getTable().getSeats(),
                reservation.getTable().getStatus());

        this.reservationRepository.save(new ReservationModel(
                reservation.getId(),
                reservation.getClient(),
                reservation.getStatus(),
                reservation.getReservationDate(),
                tableModel,
                reservation.getNotesObservations()));
    }
}
