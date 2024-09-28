package com.reservibe.domain.output.review;

import com.reservibe.domain.entity.restaurant.Restaurant;
import com.reservibe.domain.generic.output.OutputInterface;
import com.reservibe.domain.generic.output.OutputStatus;

public class ReviewOutput implements OutputInterface {
    private final OutputStatus outputStatus;

    public ReviewOutput( OutputStatus outputStatus) {

        this.outputStatus = outputStatus;
    }

    @Override
    public Restaurant getBody() {

        return null;
    }

    @Override
    public OutputStatus getOutputStatus() {
        return outputStatus;
    }
}


