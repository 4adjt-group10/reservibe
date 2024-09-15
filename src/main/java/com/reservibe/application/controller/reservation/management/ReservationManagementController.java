package com.reservibe.application.controller.reservation.management;

import com.reservibe.domain.input.reservation.ReservationManagementInput;
import com.reservibe.domain.usecase.reservation.ManagementReservationUsecase;
import com.reservibe.infra.adapter.reservation.ManagementReservationAdapter;
import com.reservibe.infra.repository.reservation.ReservationRepository;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/reservation/management")
public class ReservationManagementController {
    private final ReservationRepository reservationRepository;

    public ReservationManagementController(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @PostMapping("/{id}")
    public void manageReservation(@PathVariable UUID id,
                                  @RequestBody ReservationManagementInput reservation) {
        ManagementReservationUsecase managementReservationUsecase = new  ManagementReservationUsecase(new ManagementReservationAdapter(reservationRepository));
        managementReservationUsecase.execute(id,reservation);

    }
}
