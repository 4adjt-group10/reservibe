package com.reservibe.domain.presenters.restaurant;

import com.reservibe.domain.generic.presenter.PresenterInterface;
import com.reservibe.domain.output.restaurant.RestaurantOutput;

import java.util.List;
import java.util.Map;

public class RestaurantListPresenter implements PresenterInterface {

    private final RestaurantOutput restaurantOutput;

    public RestaurantListPresenter(RestaurantOutput restaurantOutput) {
        this.restaurantOutput = restaurantOutput;
    }

    @Override
    public Map<String, Object> toMap() {
        return Map.of();
    }

    @Override
    public Object getOutput() {
        return null;
    }
}
