package com.reservibe.infra.adapter.restaurant;

import com.reservibe.domain.entity.restaurant.Restaurant;
import com.reservibe.domain.gateway.restaurant.RegisterRestaurantInterface;
import com.reservibe.infra.model.restaurant.RestaurantModel;
import com.reservibe.infra.model.table.TableModel;
import com.reservibe.infra.repository.restaurant.RestaurantRepository;

public class RegisterRestaurantService implements RegisterRestaurantInterface {

    private final RestaurantRepository restaurantRepository;

    public RegisterRestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public Restaurant registerRestaurant(Restaurant restaurant) {
        RestaurantModel restaurantModel = restaurantRepository
                .save(new RestaurantModel(restaurant.getName(),
                        restaurant.getAddress(),
                        restaurant.getPhoneNumber(),
                        restaurant.getDescription(),
                        restaurant.getCuisine(),
                        restaurant.getOpeningHours(),
                        restaurant.getTables().stream()
                                .map(t -> new TableModel(t.getNumber(), t.getSeats(), t.getStatus())).toList()));

        restaurant.setId(restaurantModel.getId());
        return restaurant;
    }
}
