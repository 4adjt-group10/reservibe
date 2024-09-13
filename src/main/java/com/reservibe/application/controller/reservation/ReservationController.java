package com.reservibe.application.controller.reservation;

import com.reservibe.domain.input.reservation.CreateReservationInput;
import com.reservibe.domain.usecase.reservation.CreateReservationUsecase;
import com.reservibe.infra.adapter.reservation.CreateReservationService;
import com.reservibe.infra.adapter.table.SearchTableServiceById;
import com.reservibe.infra.repository.reservation.ReservationRepository;
import com.reservibe.infra.repository.table.TableModelRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reservation/create")
public class ReservationController {
    private final ReservationRepository reservationRepository;
    private final TableModelRepository  tableModelRepository;
    public ReservationController(ReservationRepository reservationRepository, TableModelRepository tableModelRepository) {
        this.reservationRepository = reservationRepository;
        this.tableModelRepository = tableModelRepository;
    }

    @PostMapping()
    public void createReservation(@RequestBody CreateReservationInput reservation) {
        CreateReservationUsecase createReservationUsecase = new
                CreateReservationUsecase(new CreateReservationService(reservationRepository),
                new SearchTableServiceById(tableModelRepository));

        createReservationUsecase.execute(reservation);
    }
}
