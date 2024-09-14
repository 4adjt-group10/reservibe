package com.reservibe.infra.adapter.reservation;

import com.reservibe.domain.entity.reservation.Reservation;
import com.reservibe.domain.enums.reservation.ReservationStatus;
import com.reservibe.infra.model.reservation.ReservationModel;
import com.reservibe.infra.repository.reservation.ReservationRepository;

public class CreateReservationAdapter {
    private final ReservationRepository reservationRepository;

    public CreateReservationAdapter(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;

    }

    public void createReservation(Reservation reservation) {
        this.reservationRepository.save(new ReservationModel(reservation.getClient(),
                ReservationStatus.CONFIRMED,
                reservation.getReservationDate(),
                reservation.getTables(),
                reservation.getNotesObservations()));

    }
}
