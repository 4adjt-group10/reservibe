package com.reservibe.infra.adapter.reservation;

import com.reservibe.domain.entity.reservation.Reservation;
import com.reservibe.infra.adapter.table.SearchTableServiceById;
import com.reservibe.infra.model.reservation.ReservationModel;
import com.reservibe.infra.repository.reservation.ReservationRepository;
import com.reservibe.infra.repository.table.TableModelRepository;

public class CreateReservationService {
    private final ReservationRepository reservationRepository;

    public CreateReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;

    }

    public void createReservation(Reservation reservation) {

        this.reservationRepository.save(new ReservationModel(reservation.getClient(),
                reservation.getStatus(),
                reservation.getReservationDate(),
                reservation.getTables(),
                reservation.getNotesObservations()));

    }
}
