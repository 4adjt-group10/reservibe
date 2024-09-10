package com.reservibe.domain.usecase.restaurant.register;

import com.reservibe.domain.entity.restaurant.Restaurant;
import com.reservibe.domain.entity.table.Table;
import com.reservibe.domain.input.restaurant.RestaurantInput;
import com.reservibe.infra.adapter.restaurant.RegisterRestaurantService;

public class RegisterRestaurantUseCase {

    private final RegisterRestaurantService registerRestaurantService;

    public RegisterRestaurantUseCase(RegisterRestaurantService registerRestaurantService) {
        this.registerRestaurantService = registerRestaurantService;
    }

    public void execute(RestaurantInput restaurantInput) {
        Restaurant restaurant = new Restaurant(restaurantInput.name(),
                restaurantInput.address(),
                restaurantInput.phoneNumber(),
                restaurantInput.description(),
                restaurantInput.cuisine(),
                restaurantInput.openingHours(), restaurantInput.tables().stream()
                .map(t -> new Table(t.number(), t.seats(), t.status())).toList());
        registerRestaurantService.registerRestaurant(restaurant);
    }
}
