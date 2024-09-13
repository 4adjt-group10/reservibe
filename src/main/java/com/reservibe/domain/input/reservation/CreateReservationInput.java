package com.reservibe.domain.input.reservation;

import com.reservibe.domain.entity.client.Client;
import com.reservibe.domain.entity.table.Table;
import com.reservibe.domain.enums.reservation.ReservationStatus;

import java.time.LocalDateTime;

public record CreateReservationInput(Client client, ReservationStatus status, LocalDateTime reservationDate, Table table, String notesObservations) {
}
