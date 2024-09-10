package com.reservibe.domain.output.restaurant;

import com.reservibe.domain.entity.restaurant.Restaurant;
import com.reservibe.domain.generic.output.OutputInterface;
import com.reservibe.domain.generic.output.OutputStatus;

public class RestaurantOutput implements OutputInterface {

    private final Restaurant body;
    private final OutputStatus outputStatus;

    public RestaurantOutput(Restaurant body, OutputStatus outputStatus) {
        this.body = body;
        this.outputStatus = outputStatus;
    }

    @Override
    public Restaurant getBody() {
        return body;
    }

    @Override
    public OutputStatus getOutputStatus() {
        return outputStatus;
    }
}
