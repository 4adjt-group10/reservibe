package com.reservibe.domain.usecase.restaurant;

import com.reservibe.domain.entity.restaurant.Restaurant;
import com.reservibe.domain.input.restaurant.RestaurantInput;
import com.reservibe.infra.adapter.restaurant.RegisterRestaurantService;
import com.reservibe.infra.repository.restaurant.RestaurantRepository;

public class RegisterRestaurantUseCase {

    private final RestaurantRepository restaurantRepository;
    private final RegisterRestaurantService registerRestaurantService;

    public RegisterRestaurantUseCase(RestaurantRepository restaurantRepository,
                                     RegisterRestaurantService registerRestaurantService) {
        this.restaurantRepository = restaurantRepository;
        this.registerRestaurantService = registerRestaurantService;
    }

    //TODO: implement
    public void execute(RestaurantInput restaurantInput) {
        Restaurant restaurant = new Restaurant(restaurantInput.name(),
                restaurantInput.address(),
                restaurantInput.phoneNumber(),
                restaurantInput.description(),
                restaurantInput.cuisine());
        registerRestaurantService.registerRestaurant(restaurant);
        //chama usecase de horarios
        //salva horarios e atualiza restaurante
    }
}
