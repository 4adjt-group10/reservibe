package com.reservibe.domain.usecase.restaurant;

import com.reservibe.domain.generic.output.OutputStatus;
import com.reservibe.domain.output.restaurant.RestaurantOutput;
import com.reservibe.infra.repository.restaurant.RestaurantRepository;

public class SearchRestaurantUseCase {

    private final RestaurantRepository restaurantRepository;

    public SearchRestaurantUseCase(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    public RestaurantOutput execute() {
        return new RestaurantOutput(restaurantRepository.findAll(),  new OutputStatus(200, "OK", "Restaurants found successfully"));
    }
}
