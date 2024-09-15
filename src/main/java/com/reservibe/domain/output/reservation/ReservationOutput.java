package com.reservibe.domain.output.reservation;

import com.reservibe.domain.entity.reservation.Reservation;
import com.reservibe.domain.generic.output.OutputInterface;
import com.reservibe.domain.generic.output.OutputStatus;

public class ReservationOutput implements OutputInterface {

    private final Reservation body;
    private final OutputStatus outputStatus;

    public ReservationOutput(Reservation body, OutputStatus outputStatus) {
        this.body = body;
        this.outputStatus = outputStatus;
    }

    @Override
    public Object getBody() {
        return this.body;
    }

    @Override
    public OutputStatus getOutputStatus() {
        return this.outputStatus;
    }
}
