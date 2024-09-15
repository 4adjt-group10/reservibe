package com.reservibe.domain.usecase.reservation;

import com.reservibe.domain.entity.reservation.Reservation;
import com.reservibe.domain.enums.reservation.ReservationStatus;
import com.reservibe.domain.enums.table.TableStatus;
import com.reservibe.domain.input.reservation.CreateReservationInput;
import com.reservibe.infra.adapter.reservation.CreateReservationAdapter;
import com.reservibe.infra.adapter.table.SearchTableByIdAdapter;

public class CreateReservationUsecase {
    private final CreateReservationAdapter createReservationAdapter;
    private final SearchTableByIdAdapter searchTableByIdAdapter;
    public CreateReservationUsecase(CreateReservationAdapter createReservationAdapter, SearchTableByIdAdapter searchTableByIdAdapter) {
        this.createReservationAdapter = createReservationAdapter;
        this.searchTableByIdAdapter = searchTableByIdAdapter;
    }

    public void execute(CreateReservationInput reservation) {
        var table = searchTableByIdAdapter.getTableByIdAndStatusIsFree(reservation.tableID());
        table.setStatus(TableStatus.RESERVED);
        var reserv = new Reservation(reservation.client(),
                ReservationStatus.CONFIRMED,reservation.reservationDate(),
                table
                ,reservation.notesObservations());
        createReservationAdapter.createReservation(reserv);
    }
}
