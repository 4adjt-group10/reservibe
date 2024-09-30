package com.reservibe.domain.input.reservation;

import com.reservibe.domain.enums.reservation.ReservationStatus;

import java.util.UUID;

public record ReservationManagementInput(
        UUID reservationID,
        ReservationStatus status
) {
}
