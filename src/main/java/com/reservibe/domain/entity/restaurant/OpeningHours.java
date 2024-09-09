package com.reservibe.domain.entity.restaurant;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class OpeningHours {

    private DayOfWeek dayOfWeek;
    private LocalTime start;
    private LocalTime end;


    public OpeningHours(DayOfWeek dayOfWeek, LocalTime start, LocalTime end) {
        this.dayOfWeek = dayOfWeek;
        this.start = start;
        this.end = end;
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
