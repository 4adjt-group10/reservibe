package com.reservibe.infra.model.restaurant;

import com.reservibe.domain.entity.restaurant.OpeningHours;
import jakarta.persistence.*;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.UUID;

@Entity
public class OpeningHoursModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Enumerated(EnumType.STRING)
    private DayOfWeek dayOfWeek;
    private LocalTime startAt;
    private LocalTime endAt;

    public OpeningHoursModel(DayOfWeek dayOfWeek, LocalTime startAt, LocalTime endAt) {
        this.dayOfWeek = dayOfWeek;
        this.startAt = startAt;
        this.endAt = endAt;
    }

    @Deprecated(since = "Only for framework use")
    public OpeningHoursModel() {

    }

    public OpeningHoursModel(OpeningHours openingHours) {
        this.dayOfWeek = openingHours.getDayOfWeek();
        this.startAt = openingHours.getStart();
        this.endAt = openingHours.getEnd();
    }

    public LocalTime getStartAt() {
        return startAt;
    }

    public LocalTime getEndAt() {
        return endAt;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

}
