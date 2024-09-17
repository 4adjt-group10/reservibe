package com.reservibe.domain.usecase.reservation;

import com.reservibe.domain.entity.reservation.Reservation;
import com.reservibe.domain.enums.reservation.ReservationStatus;
import com.reservibe.domain.enums.table.TableStatus;
import com.reservibe.domain.input.reservation.CreateReservationInput;
import com.reservibe.infra.adapter.reservation.RegisterReservationAdapter;
import com.reservibe.infra.adapter.table.UpdateTableAdapter;
import com.reservibe.infra.adapter.table.SearchTableByIdAdapter;

public class CreateReservationUsecase {
    private final RegisterReservationAdapter registerReservationAdapter;
    private final SearchTableByIdAdapter searchTableByIdAdapter;
    private final UpdateTableAdapter updateTableAdapter;

    public CreateReservationUsecase(RegisterReservationAdapter registerReservationAdapter,
                                    SearchTableByIdAdapter searchTableByIdAdapter,
                                    UpdateTableAdapter updateTableAdapter) {
        this.registerReservationAdapter = registerReservationAdapter;
        this.searchTableByIdAdapter = searchTableByIdAdapter;
        this.updateTableAdapter = updateTableAdapter;
    }

    public void execute(CreateReservationInput input) {
        var table = searchTableByIdAdapter.getTableByIdAndStatusIsFree(input.tableID());
        var reserv = new Reservation(input.client(),
                ReservationStatus.PENDING,
                input.reservationDate(),
                table,
                input.notesObservations());
        registerReservationAdapter.registerReservation(reserv);
        updateTableAdapter.updateTableWithStatus(table.getId(), TableStatus.RESERVED);
    }
}
