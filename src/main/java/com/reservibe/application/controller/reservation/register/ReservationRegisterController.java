package com.reservibe.application.controller.reservation.register;

import com.reservibe.application.response.GenericResponse;
import com.reservibe.domain.generic.output.OutputInterface;
import com.reservibe.domain.input.reservation.CreateReservationInput;
import com.reservibe.domain.usecase.reservation.CreateReservationUsecase;
import com.reservibe.infra.adapter.reservation.RegisterReservationAdapter;
import com.reservibe.infra.adapter.table.UpdateTableAdapter;
import com.reservibe.infra.adapter.table.SearchTableByIdAdapter;
import com.reservibe.infra.repository.reservation.ReservationRepository;
import com.reservibe.infra.repository.table.TableModelRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reservation/create")
public class ReservationRegisterController {
    private final ReservationRepository reservationRepository;
    private final TableModelRepository  tableModelRepository;
    public ReservationRegisterController(ReservationRepository reservationRepository, TableModelRepository tableModelRepository) {
        this.reservationRepository = reservationRepository;
        this.tableModelRepository = tableModelRepository;
    }

    @PostMapping()
    public ResponseEntity<Object> createReservation(@RequestBody CreateReservationInput reservation) {
        CreateReservationUsecase createReservationUsecase = new
                CreateReservationUsecase(new RegisterReservationAdapter(reservationRepository),
                new SearchTableByIdAdapter(tableModelRepository),
                new UpdateTableAdapter(tableModelRepository));
        createReservationUsecase.execute(reservation);
        OutputInterface outputInterface = createReservationUsecase.getReservationOutput();
        outputInterface.getOutputStatus();
        return new GenericResponse().response(outputInterface);
    }
}
