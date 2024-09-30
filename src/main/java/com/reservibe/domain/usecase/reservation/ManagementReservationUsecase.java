package com.reservibe.domain.usecase.reservation;

import com.reservibe.domain.entity.reservation.Reservation;
import com.reservibe.domain.enums.reservation.ReservationStatus;
import com.reservibe.domain.enums.table.TableStatus;
import com.reservibe.domain.generic.output.OutputError;
import com.reservibe.domain.generic.output.OutputInterface;
import com.reservibe.domain.generic.output.OutputStatus;
import com.reservibe.domain.input.reservation.ReservationManagementInput;
import com.reservibe.domain.output.management.ManagementOutput;
import com.reservibe.infra.adapter.reservation.ManagementReservationAdapter;
import com.reservibe.infra.adapter.reservation.SearchReservationAdapter;
import com.reservibe.infra.adapter.table.UpdateTableAdapter;

public class ManagementReservationUsecase {
    private final ManagementReservationAdapter managementReservationAdapter;
    private final SearchReservationAdapter searchReservationAdapter;
    private final UpdateTableAdapter updateTableAdapter;
    private OutputInterface managementOutput;

    public ManagementReservationUsecase(ManagementReservationAdapter managementReservationAdapter,
                                        SearchReservationAdapter searchReservationAdapter,
                                        UpdateTableAdapter updateTableAdapter) {
        this.managementReservationAdapter = managementReservationAdapter;
        this.searchReservationAdapter = searchReservationAdapter;
        this.updateTableAdapter = updateTableAdapter;
    }

    public void execute(ReservationManagementInput input) {
        try{
            var reservation = searchReservationAdapter.findById(input.reservationID());

            Reservation reservationUpdate = new Reservation(reservation.getId(),
                    reservation.getClient(),
                    input.status(),
                    reservation.getReservationDate(),
                    reservation.getTable(),
                    reservation.getNotesObservations());
            managementReservationAdapter.updateReservation(reservationUpdate);
            if(ReservationStatus.FINISH.equals(input.status()) ||
                    ReservationStatus.CANCELLED.equals(input.status())){
                updateTableAdapter.updateTableWithStatus(reservation.getTable().getId(),TableStatus.FREE);
            }
            this.managementOutput = new ManagementOutput(new OutputStatus(200, "ok", "ok"));
        }catch (Exception e){
            this.managementOutput = new OutputError("Erro ao gerir a reserva verifique os dados",
            new OutputStatus(404, "Not found", "Erro ao gerir a reserva verifique os dados"));
        }

    }

    public OutputInterface getManagementOutput() {
        return this.managementOutput;
    }
}
