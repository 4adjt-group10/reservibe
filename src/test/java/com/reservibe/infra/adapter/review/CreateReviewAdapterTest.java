package com.reservibe.infra.adapter.review;

import com.reservibe.domain.entity.client.Client;
import com.reservibe.domain.entity.reservation.Reservation;
import com.reservibe.domain.entity.restaurant.Address;
import com.reservibe.domain.entity.restaurant.Restaurant;
import com.reservibe.domain.entity.review.Review;
import com.reservibe.domain.entity.table.Table;
import com.reservibe.domain.enums.reservation.ReservationStatus;
import com.reservibe.domain.enums.retaurant.Cuisine;
import com.reservibe.domain.enums.review.ReviewStars;
import com.reservibe.domain.enums.table.TableStatus;
import com.reservibe.infra.adapter.reservation.SearchReservationAdapter;
import com.reservibe.infra.model.reservation.ReservationModel;
import com.reservibe.infra.model.restaurant.RestaurantModel;
import com.reservibe.infra.model.review.ReviewModel;
import com.reservibe.infra.repository.review.ReviewRepository;
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

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class CreateReviewAdapterTest {

    @Mock
    private  ReviewRepository reviewRepository;
    @Mock
    private  SearchReservationAdapter searchReservationAdapter;
    @InjectMocks
    CreateReviewAdapter createReviewAdapter ;

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
    void createReview() {
        var client = new Client("name_teste", "email@test.com", "9998845436", "11234543210");
        List<Reservation> reservationList = new ArrayList<>();
        reservationList.add(createReservationWithRestaurant(UUID.randomUUID(),client));
        Review review = new Review(reservationList.get(0).getTable().getRestaurant(),client, ReviewStars.FIVE,LocalDateTime.now(),"comment");
        when(searchReservationAdapter.findReservationByClientAndStatus(client, ReservationStatus.CONFIRMED)).thenReturn(reservationList);
        when(reviewRepository.save(any(ReviewModel.class))).thenReturn(retornoReviwModelTeste());
        createReviewAdapter.createReview(review);
        verify(searchReservationAdapter, times(1)).findReservationByClientAndStatus(client, ReservationStatus.CONFIRMED);
        verify(reviewRepository, times(1)).save(any(ReviewModel.class));



    }

    private ReviewModel retornoReviwModelTeste() {
        Address addressRestaurante = new Address("rua",123,"bairro","cidade","estado","country","3333333");
        RestaurantModel restaurant = new RestaurantModel(UUID.randomUUID(),
                "nome restaurante",
                addressRestaurante,
                "3333333",
                "descripion",
                Cuisine.AMERICAN,
                new ArrayList<>());
        ReservationModel reservationModel = new ReservationModel();
        reservationModel.setId(UUID.randomUUID());
        return new ReviewModel(restaurant,ReviewStars.FIVE,LocalDateTime.now(),"commment",reservationModel);
    }

    private Reservation createReservationWithRestaurant(UUID id, Client client) {
        ReservationStatus status = ReservationStatus.PENDING;
        LocalDateTime reservationDate = LocalDateTime.now();
        Address addressRestaurante = new Address("rua",123,"bairro","cidade","estado","country","3333333");
        Restaurant restaurant = new Restaurant(UUID.randomUUID(),
                "nome restaurante",
                addressRestaurante,
                "3333333",
                "descripion",
                Cuisine.AMERICAN,
                new ArrayList<>());
        var table = new Table(UUID.randomUUID(),1,4, TableStatus.FREE,restaurant);
        return new Reservation(id, client, status, reservationDate, table, "Fake notes");
    }
}