package com.reservibe.infra.repository.restaurant;

import com.reservibe.infra.model.restaurant.OpeningHoursModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

public interface OpeningHoursRepository extends JpaRepository<OpeningHoursModel, Long> {

    List<OpeningHoursModel> findAllByRestaurantId(UUID restaurantId);

    List<OpeningHoursModel> findAllByDayOfWeekAnd(DayOfWeek dayOfWeek);

    List<OpeningHoursModel> findAllByDayOfWeekAndAndRestaurantId(DayOfWeek dayOfWeek, Long restaurantId);

    List<OpeningHoursModel> findAllByDayOfWeekAndAndStartAtGreaterThanEqualAndEndAtLessThanEqual(DayOfWeek dayOfWeek, LocalTime startAt, LocalTime endAt);

    List<OpeningHoursModel> findAllByDayOfWeekAndStartAtGreaterThanEqualAndEndAtLessThanEqualAndRestaurantId(DayOfWeek dayOfWeek, LocalTime startAt, LocalTime endAt, UUID restaurantId);
}
