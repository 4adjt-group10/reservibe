package com.reservibe.domain.usecase.reservation;

import com.reservibe.domain.entity.client.Client;
import com.reservibe.domain.entity.reservation.ReservationSearche;
import com.reservibe.domain.enums.reservation.ReservationStatus;
import com.reservibe.domain.output.reservation.ReservationListSearchList;
import com.reservibe.infra.adapter.reservation.SearchReservationAdapter;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class SearchReservationUseCaseTest {

    @Mock
    private SearchReservationAdapter searchReservationAdapter;

    @InjectMocks
    private SearchReservationUseCase searchReservationUseCase;

    AutoCloseable openMocks;
    @BeforeEach
    void setup(){
        openMocks = MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    void tearDown() throws Exception {
        openMocks.close();
    }

    @Test
    void execute() {

        List<ReservationSearche> mockReservations = new ArrayList<>();
        mockReservations.add(createReservation());
        when(searchReservationAdapter.findReservationByRestaurantId(mockReservations.get(0).getId())).thenReturn(mockReservations);

        ReservationListSearchList result = searchReservationUseCase.execute(mockReservations.get(0).getId());
        assertNotNull(result);
        assertEquals(mockReservations.get(0).getId(), result.getBody().get(0).getId());
    }


    @Test
    void executeNoContent() {
        UUID restaurantId = UUID.randomUUID();
        List<ReservationSearche> mockReservations = new ArrayList<>();
        when(searchReservationAdapter.findReservationByRestaurantId(restaurantId)).thenReturn(mockReservations);

        ReservationListSearchList result = searchReservationUseCase.execute(restaurantId);
        assertEquals(0, result.getBody().size());
    }


    public final ReservationSearche createReservation() {
        UUID restaurantId = UUID.randomUUID();
        var client = new Client("name_teste", "email@test.com", "9998845436", "11234543210");
        ReservationStatus status = ReservationStatus.PENDING;
        LocalDateTime reservationDate = LocalDateTime.now();
        return new ReservationSearche(restaurantId, client, status, reservationDate, "Fake notes");
    }
}