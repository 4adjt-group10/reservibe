package com.reservibe.infra.adapter.reservation;

import com.reservibe.domain.entity.client.Client;
import com.reservibe.domain.entity.restaurant.Address;
import com.reservibe.domain.enums.reservation.ReservationStatus;
import com.reservibe.domain.enums.retaurant.Cuisine;
import com.reservibe.domain.enums.table.TableStatus;
import com.reservibe.infra.model.reservation.ReservationModel;
import com.reservibe.infra.model.restaurant.RestaurantModel;
import com.reservibe.infra.model.table.TableModel;
import com.reservibe.infra.repository.reservation.ReservationRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class SearchReservationAdapterTest {
    @Mock
    private  ReservationRepository reservationRepository;
    @InjectMocks
    SearchReservationAdapter searchReservationAdapter;

    private AutoCloseable closeable;

    @BeforeEach
    void setUp() {
        closeable = MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    void tearDown() throws Exception {
        closeable.close();
    }

    @Test
    void findReservationByRestaurantId() {
        UUID id = UUID.randomUUID();
        List<ReservationModel> reservationList = new ArrayList<>();
        reservationList.add(createReservation(id));
        when(reservationRepository.listByRestaurantId(id)).thenReturn(reservationList);
        var retorno = searchReservationAdapter.findReservationByRestaurantId(id);
        verify(reservationRepository, times(1)).listByRestaurantId(any(UUID.class));
        assertEquals(retorno.size(), 1);
    }



    @Test
    void findReservationByClientAndStatus() {
        UUID id = UUID.randomUUID();
        List<ReservationModel> reservationList = new ArrayList<>();
        reservationList.add(createReservationWithRestaurant(id));
        when(reservationRepository.listByClientAndStatus(reservationList.get(0).getClient(),ReservationStatus.PENDING.toString())).thenReturn(reservationList);
        var retorno = searchReservationAdapter.findReservationByClientAndStatus(reservationList.get(0).getClient(),ReservationStatus.PENDING);
        verify(reservationRepository, times(1)).listByClientAndStatus(reservationList.get(0).getClient(), ReservationStatus.PENDING.toString());
        assertEquals(retorno.size(), 1);
    }

    private ReservationModel createReservationWithRestaurant(UUID id) {
        var client = new Client("name_teste", "email@test.com", "9998845436", "11234543210");
        ReservationStatus status = ReservationStatus.PENDING;
        LocalDateTime reservationDate = LocalDateTime.now();
        Address addressRestaurante = new Address("rua",123,"bairro","cidade","estado","country","3333333");
        RestaurantModel restaurantModel = new RestaurantModel(UUID.randomUUID(),
                "nome restaurante",
                addressRestaurante,
                "3333333",
                "descripion",
                Cuisine.AMERICAN,
                new ArrayList<>());
        var table = new TableModel(1,4, TableStatus.FREE,restaurantModel);
        return new ReservationModel(id, client, status, reservationDate, table, "Fake notes");
    }

    @Test
    void findById() {
        UUID id = UUID.randomUUID();
        var createReservation = createReservation(id);
        when(reservationRepository.findById(id)).thenReturn(Optional.of(createReservation));
        var retorno = searchReservationAdapter.findById(id);
        verify(reservationRepository, times(1)).findById(any(UUID.class));

        assertEquals(retorno.getClient(), createReservation.getClient());
        assertEquals(retorno.getStatus(), createReservation.getStatus());

    }
    public final ReservationModel createReservation(UUID id) {
        var client = new Client("name_teste", "email@test.com", "9998845436", "11234543210");
        ReservationStatus status = ReservationStatus.PENDING;
        LocalDateTime reservationDate = LocalDateTime.now();
        var table = new TableModel(1,4, TableStatus.FREE);
        return new ReservationModel(id, client, status, reservationDate, table, "Fake notes");
    }

}