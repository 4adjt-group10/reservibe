package com.reservibe.domain.input.reservation;

import com.reservibe.domain.entity.client.Client;

import java.time.LocalDateTime;
import java.util.UUID;

public record CreateReservationInput(Client client, LocalDateTime reservationDate, UUID tableID, String notesObservations) {
}
