package com.reservibe.domain.gateway.reservation;

import com.reservibe.domain.entity.reservation.Reservation;

import java.util.List;
import java.util.UUID;

public interface SearchReservationInterface {

    List<Reservation> findReservationByRestaurantId(UUID code);
}
