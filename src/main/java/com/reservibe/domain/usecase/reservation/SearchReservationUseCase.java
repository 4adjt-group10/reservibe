package com.reservibe.domain.usecase.reservation;

import com.reservibe.domain.generic.output.OutputStatus;
import com.reservibe.domain.output.reservation.ReservationListOutput;
import com.reservibe.infra.adapter.reservation.SearchReservationAdapter;

import java.util.UUID;

public class SearchReservationUseCase {

    private final SearchReservationAdapter searchReservationAdapter;

    public SearchReservationUseCase(SearchReservationAdapter searchReservationAdapter) {
        this.searchReservationAdapter = searchReservationAdapter;
    }

    public ReservationListOutput execute(UUID restaurantId) {
        return new ReservationListOutput(searchReservationAdapter.findReservationByRestaurantId(restaurantId),
                new OutputStatus(200, "OK", "Reservations found successfully"));
    }
}
