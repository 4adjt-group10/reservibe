package com.reservibe.domain.usecase.restaurant.register;

import com.reservibe.domain.entity.restaurant.Restaurant;
import com.reservibe.domain.entity.table.Table;
import com.reservibe.domain.input.restaurant.RestaurantInput;
import com.reservibe.infra.adapter.restaurant.RegisterRestaurantAdapter;

public class RegisterRestaurantUseCase {

    private final RegisterRestaurantAdapter registerRestaurantAdapter;

    public RegisterRestaurantUseCase(RegisterRestaurantAdapter registerRestaurantAdapter) {
        this.registerRestaurantAdapter = registerRestaurantAdapter;
    }

    public void execute(RestaurantInput restaurantInput) {
        Restaurant restaurant = new Restaurant(restaurantInput.name(),
                restaurantInput.address(),
                restaurantInput.phoneNumber(),
                restaurantInput.description(),
                restaurantInput.cuisine(),
                restaurantInput.openingHours(), restaurantInput.tables().stream()
                .map(t -> new Table(t.number(), t.seats(), t.status())).toList());
        registerRestaurantAdapter.registerRestaurant(restaurant);
    }
}
