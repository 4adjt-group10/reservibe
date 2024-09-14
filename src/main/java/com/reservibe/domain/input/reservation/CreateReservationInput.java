package com.reservibe.domain.input.reservation;

import com.reservibe.domain.entity.client.Client;
import com.reservibe.domain.entity.table.Table;
import com.reservibe.domain.enums.reservation.ReservationStatus;
import com.reservibe.domain.input.table.TableInput;

import java.time.LocalDateTime;
import java.util.UUID;

public record CreateReservationInput(Client client, LocalDateTime reservationDate, UUID tableID, String notesObservations) {
}
