package com.reservibe.domain.generic.presenter;

import com.reservibe.domain.generic.output.OutputInterface;

import java.util.Map;

public interface PresenterInterface {
    Map<String, Object> toMap();

    OutputInterface getOutput();
}
