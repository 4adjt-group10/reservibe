package com.reservibe.domain.usecase.reservation;

import com.reservibe.domain.entity.client.Client;
import com.reservibe.domain.entity.reservation.Reservation;
import com.reservibe.domain.entity.table.Table;
import com.reservibe.domain.enums.reservation.ReservationStatus;
import com.reservibe.domain.enums.table.TableStatus;
import com.reservibe.domain.input.reservation.ReservationManagementInput;
import com.reservibe.infra.adapter.reservation.ManagementReservationAdapter;
import com.reservibe.infra.adapter.reservation.SearchReservationAdapter;
import com.reservibe.infra.adapter.table.UpdateTableAdapter;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class ManagementReservationUsecaseTest {

    @Mock
    private ManagementReservationAdapter managementReservationAdapter;
    @Mock
    private  SearchReservationAdapter searchReservationAdapter;
    @Mock
    private  UpdateTableAdapter updateTableAdapter;

    @InjectMocks
    private ManagementReservationUsecase managementReservationUsecase;

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
        UUID id = UUID.randomUUID();
        var createReservationInput = createReservationInput();
        var createReservation = createReservation();
        when(searchReservationAdapter.findById(id)).thenReturn(createReservation);
        doNothing().when(managementReservationAdapter).updateReservation(any(Reservation.class));


        managementReservationUsecase.execute(id, createReservationInput);
        verify(managementReservationAdapter, times(1)).updateReservation(any(Reservation.class));
    }

    public final ReservationManagementInput createReservationInput() {
        var client = new Client("name_teste", "email@test.com", "9998845436", "11234543210");
        ReservationStatus status = ReservationStatus.PENDING;
        LocalDateTime reservationDate = LocalDateTime.now();
        UUID tableID = UUID.randomUUID();
        return new ReservationManagementInput(client, reservationDate, tableID ,status, "Fake notes");
    }

    public final Reservation createReservation() {
        UUID restaurantId = UUID.randomUUID();
        var client = new Client("name_teste", "email@test.com", "9998845436", "11234543210");
        ReservationStatus status = ReservationStatus.PENDING;
        LocalDateTime reservationDate = LocalDateTime.now();
        var table = new Table(1,4, TableStatus.FREE);
        return new Reservation(restaurantId, client, status, reservationDate, table, "Fake notes");
    }
}