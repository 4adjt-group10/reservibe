package com.reservibe.domain.output.reservation;

import com.reservibe.domain.entity.reservation.ReservationSearche;
import com.reservibe.domain.generic.output.OutputInterface;
import com.reservibe.domain.generic.output.OutputStatus;

import java.util.List;

public class ReservationListSearchList implements OutputInterface {

    private final List<ReservationSearche> body;
    private final OutputStatus outputStatus;

    public ReservationListSearchList(List<ReservationSearche> body, OutputStatus outputStatus) {
        this.body = body;
        this.outputStatus = outputStatus;
    }

    @Override
    public List<ReservationSearche> getBody() {
        return this.body;
    }

    @Override
    public OutputStatus getOutputStatus() {
        return this.outputStatus;
    }
}


