package com.reservibe.application.controller.restaurant;

import com.reservibe.domain.input.restaurant.RestaurantInput;
import com.reservibe.domain.usecase.restaurant.register.RegisterRestaurantUseCase;
import com.reservibe.infra.adapter.restaurant.RegisterRestaurantService;
import com.reservibe.infra.repository.restaurant.RestaurantRepository;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/restaurant/register")
public class RestaurantRegisterController {

    private final RestaurantRepository restaurantRepository;

    public RestaurantRegisterController(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @PostMapping()
    public void registerRestaurant(@RequestBody @Valid RestaurantInput input) {
        RegisterRestaurantUseCase registerRestaurantUseCase = new RegisterRestaurantUseCase(new RegisterRestaurantService(restaurantRepository));
        registerRestaurantUseCase.execute(input);
    }
}
