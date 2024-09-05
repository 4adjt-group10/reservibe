package com.reservibe.domain.input.restaurant;

import java.time.DayOfWeek;
import java.time.LocalTime;

public record OpeningHoursInput(DayOfWeek dayOfWeek, LocalTime startAt, LocalTime endAt) {
}
