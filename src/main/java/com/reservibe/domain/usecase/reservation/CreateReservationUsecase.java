package com.reservibe.domain.usecase.reservation;

import com.reservibe.domain.entity.reservation.Reservation;
import com.reservibe.domain.enums.reservation.ReservationStatus;
import com.reservibe.domain.enums.table.TableStatus;
import com.reservibe.domain.generic.output.OutputError;
import com.reservibe.domain.generic.output.OutputInterface;
import com.reservibe.domain.generic.output.OutputStatus;
import com.reservibe.domain.input.reservation.CreateReservationInput;
import com.reservibe.domain.output.management.ManagementOutput;
import com.reservibe.domain.output.reservation.ReservationOutput;
import com.reservibe.infra.adapter.reservation.RegisterReservationAdapter;
import com.reservibe.infra.adapter.table.UpdateTableAdapter;
import com.reservibe.infra.adapter.table.SearchTableByIdAdapter;

public class CreateReservationUsecase {
    private final RegisterReservationAdapter registerReservationAdapter;
    private final SearchTableByIdAdapter searchTableByIdAdapter;
    private final UpdateTableAdapter updateTableAdapter;
    private OutputInterface reservationOutput;

    public CreateReservationUsecase(RegisterReservationAdapter registerReservationAdapter,
                                    SearchTableByIdAdapter searchTableByIdAdapter,
                                    UpdateTableAdapter updateTableAdapter) {
        this.registerReservationAdapter = registerReservationAdapter;
        this.searchTableByIdAdapter = searchTableByIdAdapter;
        this.updateTableAdapter = updateTableAdapter;
    }

    public void execute(CreateReservationInput input) {
        try{
            var table = searchTableByIdAdapter.getTableByIdAndStatusIsFree(input.tableID());
            var reserv = new Reservation(input.client(),
                    ReservationStatus.PENDING,
                    input.reservationDate(),
                    table,
                    input.notesObservations());
            registerReservationAdapter.registerReservation(reserv);
            updateTableAdapter.updateTableWithStatus(table.getId(), TableStatus.RESERVED);
            this.reservationOutput = new ReservationOutput(new Reservation(),new OutputStatus(200, "ok", "ok"));

        }catch (Exception e){
            this.reservationOutput = new OutputError("Erro ao gerir a reserva verifique os dados",
                    new OutputStatus(404, "Not found", "Erro ao gerir a reserva verifique os dados"));
        }
    }

    public OutputInterface getReservationOutput() {
        return this.reservationOutput;
    }
}
