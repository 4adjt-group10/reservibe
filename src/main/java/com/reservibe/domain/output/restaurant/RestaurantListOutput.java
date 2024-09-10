package com.reservibe.domain.output.restaurant;

import com.reservibe.domain.entity.restaurant.Restaurant;
import com.reservibe.domain.generic.output.OutputInterface;
import com.reservibe.domain.generic.output.OutputStatus;

import java.util.List;

public class RestaurantListOutput implements OutputInterface {

    private final List<Restaurant> body;
    private final OutputStatus outputStatus;

    public RestaurantListOutput(List<Restaurant> body, OutputStatus outputStatus) {
        this.body = body;
        this.outputStatus = outputStatus;
    }

    @Override
    public List<Restaurant> getBody() {
        return body;
    }

    @Override
    public OutputStatus getOutputStatus() {
        return outputStatus;
    }
}
