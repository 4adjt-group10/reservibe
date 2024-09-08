package com.reservibe.infra.repository.restaurant;

import com.reservibe.infra.model.restaurant.OpeningHoursModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

public interface OpeningHoursRepository extends JpaRepository<OpeningHoursModel, UUID> {

    List<OpeningHoursModel> findAllByRestaurantId(UUID restaurantId);

    List<OpeningHoursModel> findAllByDayOfWeek(DayOfWeek dayOfWeek);

    List<OpeningHoursModel> findAllByDayOfWeekAndRestaurantId(DayOfWeek dayOfWeek, UUID restaurantId);

    List<OpeningHoursModel> findAllByDayOfWeekAndStartAtGreaterThanEqualAndEndAtLessThanEqual(DayOfWeek dayOfWeek, LocalTime startAt, LocalTime endAt);

    List<OpeningHoursModel> findAllByDayOfWeekAndStartAtGreaterThanEqualAndEndAtLessThanEqualAndRestaurantId(DayOfWeek dayOfWeek, LocalTime startAt, LocalTime endAt, UUID restaurantId);
}
