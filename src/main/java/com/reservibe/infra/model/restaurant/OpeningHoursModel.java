package com.reservibe.infra.model.restaurant;

import com.reservibe.domain.entity.restaurant.OpeningHours;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class OpeningHoursModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private DayOfWeek dayOfWeek;
    private LocalDateTime start;
    private LocalDateTime end;

    public OpeningHoursModel(DayOfWeek dayOfWeek, LocalDateTime start, LocalDateTime end) {
        this.dayOfWeek = dayOfWeek;
        this.start = start;
        this.end = end;
    }

    @Deprecated(since = "Only for framework use")
    public OpeningHoursModel() {

    }

    public OpeningHoursModel(OpeningHours openingHours) {
        this.dayOfWeek = openingHours.getDayOfWeek();
        this.start = openingHours.getStart();
        this.end = openingHours.getEnd();
    }

    public LocalDateTime getStart() {
        return start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

}
