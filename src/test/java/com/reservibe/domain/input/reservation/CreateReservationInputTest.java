package com.reservibe.domain.input.reservation;

import com.reservibe.domain.entity.client.Client;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CreateReservationInputTest {

    @Test
    public void testCreateReservationInput() {
        var client = new Client("name_teste", "email@test.com", "9998845436", "11234543210");
        LocalDateTime reservationDate = LocalDateTime.now();
        UUID tableID = UUID.randomUUID();
        String notesObservations = "Some notes";

        CreateReservationInput input = new CreateReservationInput(client, reservationDate, tableID, notesObservations);

        assertNotNull(input);
        assertEquals(client, input.client());
        assertEquals(reservationDate, input.reservationDate());
        assertEquals(tableID, input.tableID());
        assertEquals(notesObservations, input.notesObservations());
    }
}