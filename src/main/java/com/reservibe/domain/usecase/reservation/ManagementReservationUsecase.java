package com.reservibe.domain.usecase.reservation;

import com.reservibe.domain.entity.reservation.Reservation;
import com.reservibe.domain.enums.reservation.ReservationStatus;
import com.reservibe.domain.enums.table.TableStatus;
import com.reservibe.domain.input.reservation.ReservationManagementInput;
import com.reservibe.infra.adapter.reservation.ManagementReservationAdapter;
import com.reservibe.infra.adapter.table.UpdateTableAdapter;

import java.util.UUID;

public class ManagementReservationUsecase {
    private final ManagementReservationAdapter managementReservationAdapter;
    private final UpdateTableAdapter updateTableAdapter;

    public ManagementReservationUsecase(ManagementReservationAdapter managementReservationAdapter, UpdateTableAdapter updateTableAdapter) {
        this.managementReservationAdapter = managementReservationAdapter;
        this.updateTableAdapter = updateTableAdapter;
    }

    public void execute(UUID id, ReservationManagementInput reservation) {
        var reserv = managementReservationAdapter.findById(id);

        Reservation reservationUpdate = new Reservation(reserv.getId(),
                reservation.client(),
                reservation.status(),
                reservation.reservationDate(),
                reserv.getTable(),
                reservation.notesObservations());
        managementReservationAdapter.updateReserver(reservationUpdate);
        if(ReservationStatus.FINISH.equals(reservation.status()) ||
                ReservationStatus.CANCELLED.equals(reservation.status())){
            updateTableAdapter.updateTableWithStatus(reserv.getTable().getId(),TableStatus.FREE);
        }

    }
}
