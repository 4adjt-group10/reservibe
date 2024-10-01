package com.reservibe.domain.gateway.reservation;

import com.reservibe.domain.entity.client.Client;
import com.reservibe.domain.entity.reservation.Reservation;
import com.reservibe.domain.entity.reservation.ReservationSearche;
import com.reservibe.domain.enums.reservation.ReservationStatus;

import java.util.List;
import java.util.UUID;

public interface SearchReservationInterface {

    List<ReservationSearche> findReservationByRestaurantId(UUID code);

    List<Reservation> findReservationByClientAndStatus(Client client, ReservationStatus status);

    Reservation findById(UUID id);
}
