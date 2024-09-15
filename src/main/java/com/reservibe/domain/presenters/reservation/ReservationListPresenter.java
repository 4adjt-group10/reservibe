package com.reservibe.domain.presenters.reservation;

import com.reservibe.domain.generic.output.OutputInterface;
import com.reservibe.domain.generic.presenter.PresenterInterface;
import com.reservibe.domain.output.reservation.ReservationListOutput;

import java.util.HashMap;
import java.util.Map;

public class ReservationListPresenter implements PresenterInterface {

    private final ReservationListOutput listOutput;

    public ReservationListPresenter(ReservationListOutput listOutput) {
        this.listOutput = listOutput;
    }

    @Override
    public Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("reservations", listOutput.getBody());
        return map;
    }

    @Override
    public OutputInterface getOutput() {
        return listOutput;
    }
}
