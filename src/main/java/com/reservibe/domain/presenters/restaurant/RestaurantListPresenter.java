package com.reservibe.domain.presenters.restaurant;

import com.reservibe.domain.generic.presenter.PresenterInterface;
import com.reservibe.domain.output.restaurant.RestaurantListOutput;

import java.util.HashMap;
import java.util.Map;

public class RestaurantListPresenter implements PresenterInterface {

    private final RestaurantListOutput listOutput;

    public RestaurantListPresenter(RestaurantListOutput listOutput) {
        this.listOutput = listOutput;
    }

    @Override
    public Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("restaurants", listOutput.getBody());
        return map;
    }

    @Override
    public RestaurantListOutput getOutput() {
        return listOutput;
    }
}
