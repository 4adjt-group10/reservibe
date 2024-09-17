package com.reservibe.application.controller.reservation.management;

import com.reservibe.domain.input.reservation.ReservationManagementInput;
import com.reservibe.domain.usecase.reservation.ManagementReservationUsecase;
import com.reservibe.infra.adapter.reservation.ManagementReservationAdapter;
import com.reservibe.infra.adapter.reservation.SearchReservationAdapter;
import com.reservibe.infra.adapter.table.UpdateTableAdapter;
import com.reservibe.infra.repository.reservation.ReservationRepository;
import com.reservibe.infra.repository.table.TableModelRepository;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/reservation/management")
public class ReservationManagementController {
    private final ReservationRepository reservationRepository;
    private final TableModelRepository tableModelRepository;

    public ReservationManagementController(ReservationRepository reservationRepository, TableModelRepository tableModelRepository) {
        this.reservationRepository = reservationRepository;
        this.tableModelRepository = tableModelRepository;
    }

    @PostMapping("/{id}")
    public void manageReservation(@PathVariable UUID id,
                                  @RequestBody ReservationManagementInput reservation) {
        ManagementReservationUsecase managementReservationUsecase = new ManagementReservationUsecase(
                new ManagementReservationAdapter(reservationRepository),
                new SearchReservationAdapter(reservationRepository),
                new UpdateTableAdapter(tableModelRepository));
        managementReservationUsecase.execute(id,reservation);
    }
}
