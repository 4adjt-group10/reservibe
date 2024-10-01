package com.reservibe.domain.usecase.reservation;

import com.reservibe.domain.generic.output.OutputStatus;
import com.reservibe.domain.output.reservation.ReservationListOutput;
import com.reservibe.infra.adapter.reservation.SearchReservationAdapter;

import java.util.ArrayList;
import java.util.UUID;

public class SearchReservationUseCase {

    private final SearchReservationAdapter searchReservationAdapter;

    public SearchReservationUseCase(SearchReservationAdapter searchReservationAdapter) {
        this.searchReservationAdapter = searchReservationAdapter;
    }

    public ReservationListOutput execute(UUID restaurantId) {
        var reservationList = searchReservationAdapter.findReservationByRestaurantId(restaurantId);
        if(!reservationList.isEmpty()){
            return new ReservationListOutput(reservationList,
                    new OutputStatus(200, "OK", "Reservations found successfully"));
        }
        return new ReservationListOutput(new ArrayList<>(),
                new OutputStatus(400, "Bad Request", "Reservations not found"));
    }
}
