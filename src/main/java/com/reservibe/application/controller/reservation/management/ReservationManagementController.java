package com.reservibe.application.controller.reservation.management;

import com.reservibe.application.response.GenericResponse;
import com.reservibe.domain.generic.output.OutputInterface;
import com.reservibe.domain.input.reservation.ReservationManagementInput;
import com.reservibe.domain.usecase.reservation.ManagementReservationUsecase;
import com.reservibe.infra.adapter.reservation.ManagementReservationAdapter;
import com.reservibe.infra.adapter.reservation.SearchReservationAdapter;
import com.reservibe.infra.adapter.table.UpdateTableAdapter;
import com.reservibe.infra.repository.reservation.ReservationRepository;
import com.reservibe.infra.repository.table.TableModelRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reservation/management")
public class ReservationManagementController {
    private final ReservationRepository reservationRepository;
    private final TableModelRepository tableModelRepository;

    public ReservationManagementController(ReservationRepository reservationRepository, TableModelRepository tableModelRepository) {
        this.reservationRepository = reservationRepository;
        this.tableModelRepository = tableModelRepository;
    }

    @PutMapping()
    public ResponseEntity<Object> manageReservation(@RequestBody ReservationManagementInput input) {
        ManagementReservationUsecase managementReservationUsecase = new ManagementReservationUsecase(
                new ManagementReservationAdapter(reservationRepository),
                new SearchReservationAdapter(reservationRepository),
                new UpdateTableAdapter(tableModelRepository));
        managementReservationUsecase.execute(input);
        OutputInterface outputInterface = managementReservationUsecase.getManagementOutput();
        outputInterface.getOutputStatus();
        return new GenericResponse().response(outputInterface);
    }
}
