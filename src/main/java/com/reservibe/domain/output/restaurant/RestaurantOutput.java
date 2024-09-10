package com.reservibe.domain.output.restaurant;

import com.reservibe.domain.generic.output.OutputInterface;
import com.reservibe.domain.generic.output.OutputStatus;

public class RestaurantOutput implements OutputInterface {

    private final Object body;
    private final OutputStatus outputStatus;

    public RestaurantOutput(Object body, OutputStatus outputStatus) {
        this.body = body;
        this.outputStatus = outputStatus;
    }

    @Override
    public Object getBody() {
        return body;
    }

    @Override
    public OutputStatus getOutputStatus() {
        return outputStatus;
    }
}
