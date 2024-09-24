package com.reservibe.domain.output.reservation;

import com.reservibe.domain.entity.reservation.Reservation;
import com.reservibe.domain.generic.output.OutputStatus;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import java.util.List;

public class ReservationListOutputTest {

    @Test
    public void testGetBody() {
        List<Reservation> mockReservations = List.of(mock(Reservation.class), mock(Reservation.class));
        OutputStatus mockOutputStatus = mock(OutputStatus.class);
        ReservationListOutput reservationListOutput = new ReservationListOutput(mockReservations, mockOutputStatus);

        assertEquals(mockReservations, reservationListOutput.getBody());
    }

    @Test
    public void testGetOutputStatus() {
        List<Reservation> mockReservations = List.of(mock(Reservation.class), mock(Reservation.class));
        OutputStatus mockOutputStatus = mock(OutputStatus.class);
        ReservationListOutput reservationListOutput = new ReservationListOutput(mockReservations, mockOutputStatus);

        assertEquals(mockOutputStatus, reservationListOutput.getOutputStatus());
    }
}