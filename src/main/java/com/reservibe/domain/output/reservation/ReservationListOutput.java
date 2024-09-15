package com.reservibe.domain.output.reservation;

import com.reservibe.domain.entity.reservation.Reservation;
import com.reservibe.domain.generic.output.OutputInterface;
import com.reservibe.domain.generic.output.OutputStatus;

import java.util.List;

public class ReservationListOutput implements OutputInterface {

    private final List<Reservation> body;
    private final OutputStatus outputStatus;

    public ReservationListOutput(List<Reservation> body, OutputStatus outputStatus) {
        this.body = body;
        this.outputStatus = outputStatus;
    }

    @Override
    public List<Reservation> getBody() {
        return this.body;
    }

    @Override
    public OutputStatus getOutputStatus() {
        return this.outputStatus;
    }
}
