package com.reservibe.infra.repository.restaurant;

import com.reservibe.domain.entity.restaurant.Address;
import com.reservibe.domain.entity.restaurant.OpeningHours;
import com.reservibe.domain.enums.retaurant.Cuisine;
import com.reservibe.infra.model.restaurant.RestaurantModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface RestaurantRepository extends JpaRepository<RestaurantModel, Long> {

    Optional<RestaurantModel> findByName(String name);

    List<RestaurantModel> findAllByCuisine(Cuisine cuisine);

    @Query("""
        SELECT r FROM RestaurantModel r
         WHERE jsonb_extract_path_text(r.openingHours, 'start') = :start
           AND jsonb_extract_path_text(r.openingHours, 'end') = :end
    """)
    List<RestaurantModel> findAllByStartsAndEndHours(@Param("start") String start, @Param("end") String end);

    @Query(value = """
        SELECT r.* FROM restaurant_model r
        WHERE r.opening_hours @> cast(:openingHours as jsonb)
    """, nativeQuery = true)
    List<RestaurantModel> findAllByOpeningHours(@Param("openingHours") OpeningHours openingHours);

    @Query("""
        SELECT r FROM RestaurantModel r
         WHERE jsonb_extract_path_text(r.openingHours, 'dayOfWeek') = :dayOfWeek
    """)
    List<RestaurantModel> findAllByOpeningDayOfWeek(@Param("dayOfWeek") String dayOfWeek);

    @Query("""
        SELECT r FROM RestaurantModel r
        WHERE jsonb_extract_path_text(r.address, 'city') = :city
    """)
    List<RestaurantModel> findAllByAddress_City(@Param("city") String city);

    @Query(value = """
        SELECT r.* FROM restaurant_model r
        WHERE r.address @> cast(:address as jsonb)
    """, nativeQuery = true)
    List<RestaurantModel> findAllByAddress(@Param("address") Address address);
}
