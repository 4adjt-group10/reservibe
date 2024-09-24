package com.reservibe.domain.output.reservation;

import com.reservibe.domain.entity.reservation.Reservation;
import com.reservibe.domain.generic.output.OutputStatus;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class ReservationOutputTest {

    @Test
    public void testGetBody() {
        Reservation mockReservation = mock(Reservation.class);
        OutputStatus mockOutputStatus = mock(OutputStatus.class);
        ReservationOutput reservationOutput = new ReservationOutput(mockReservation, mockOutputStatus);

        assertEquals(mockReservation, reservationOutput.getBody());
    }

    @Test
    public void testGetOutputStatus() {
        Reservation mockReservation = mock(Reservation.class);
        OutputStatus mockOutputStatus = mock(OutputStatus.class);
        ReservationOutput reservationOutput = new ReservationOutput(mockReservation, mockOutputStatus);

        assertEquals(mockOutputStatus, reservationOutput.getOutputStatus());
    }
}