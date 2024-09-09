package com.reservibe.infra.repository.restaurant;

import com.reservibe.domain.enums.retaurant.Cuisine;
import com.reservibe.infra.model.restaurant.RestaurantModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RestaurantRepository extends JpaRepository<RestaurantModel, Long> {

    List<RestaurantModel> findAllByCuisine(Cuisine cuisine);

}
