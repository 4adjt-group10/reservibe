package com.reservibe.domain.entity.restaurant;

import com.reservibe.infra.model.restaurant.OpeningHoursModel;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class OpeningHours {

    private final DayOfWeek dayOfWeek;
    private final LocalTime start;
    private final LocalTime end;

    public OpeningHours(DayOfWeek dayOfWeek, LocalTime start, LocalTime end) {
        this.dayOfWeek = dayOfWeek;
        this.start = start;
        this.end = end;
    }

    public OpeningHours(OpeningHoursModel openingHoursModel) {
        this(openingHoursModel.getDayOfWeek(), openingHoursModel.getStartAt(), openingHoursModel.getEndAt());
    }

    public LocalTime getStart() {
        return start;
    }

    public LocalTime getEnd() {
        return end;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public boolean isOpen(LocalDateTime dateTime) {
        return dateTime.getDayOfWeek().equals(dayOfWeek)
                && !dateTime.toLocalTime().isBefore(start)
                && !dateTime.toLocalTime().isAfter(end);
    }

    public boolean isClosed(LocalDateTime dateTime) {
        return !isOpen(dateTime);
    }

    public boolean isBeforeOpening(LocalDateTime dateTime) {
        return dateTime.getDayOfWeek().equals(dayOfWeek) && dateTime.toLocalTime().isBefore(start);
    }

    public boolean isAfterClosing(LocalDateTime dateTime) {
        return dateTime.getDayOfWeek().equals(dayOfWeek) && dateTime.toLocalTime().isAfter(end);
    }

}
