package com.reservibe.domain.presenters.reservation;

import com.reservibe.domain.generic.output.OutputInterface;
import com.reservibe.domain.generic.presenter.PresenterInterface;
import com.reservibe.domain.output.reservation.ReservationOutput;

import java.util.Map;

public class ReservationPresenter implements PresenterInterface {

    private final ReservationOutput output;

    public ReservationPresenter(ReservationOutput output) {
        this.output = output;
    }

    @Override
    public Map<String, Object> toMap() {
        return Map.of("reservation", output.getBody());
    }

    @Override
    public OutputInterface getOutput() {
        return this.output;
    }
}
