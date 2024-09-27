package com.reservibe.domain.output.register;

import com.reservibe.domain.entity.restaurant.Restaurant;
import com.reservibe.domain.generic.output.OutputInterface;
import com.reservibe.domain.generic.output.OutputStatus;

public class RegisterOutput implements OutputInterface {

    private final OutputStatus outputStatus;

    public RegisterOutput( OutputStatus outputStatus) {

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


