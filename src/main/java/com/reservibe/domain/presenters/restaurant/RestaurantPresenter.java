package com.reservibe.domain.presenters.restaurant;

import com.reservibe.domain.generic.presenter.PresenterInterface;
import com.reservibe.domain.output.restaurant.RestaurantOutput;

import java.util.Map;

public class RestaurantPresenter implements PresenterInterface {

    private final RestaurantOutput output;

    public RestaurantPresenter(RestaurantOutput output) {
        this.output = output;
    }

    @Override
    public Map<String, Object> toMap() {
        return Map.of("restaurant", output.getBody());
    }

    @Override
    public RestaurantOutput getOutput() {
        return output;
    }
}
