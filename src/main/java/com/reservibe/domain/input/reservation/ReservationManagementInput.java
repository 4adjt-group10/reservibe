package com.reservibe.domain.input.reservation;

import com.reservibe.domain.entity.client.Client;
import com.reservibe.domain.enums.reservation.ReservationStatus;

import java.time.LocalDateTime;
import java.util.UUID;

public record ReservationManagementInput(
        UUID reservationID,
        ReservationStatus status
) {
}
