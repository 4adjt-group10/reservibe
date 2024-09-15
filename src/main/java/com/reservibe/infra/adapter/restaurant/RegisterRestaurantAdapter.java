package com.reservibe.infra.adapter.restaurant;

import com.reservibe.domain.entity.restaurant.Restaurant;
import com.reservibe.domain.gateway.restaurant.RegisterRestaurantInterface;
import com.reservibe.infra.model.restaurant.RestaurantModel;
import com.reservibe.infra.model.table.TableModel;
import com.reservibe.infra.repository.restaurant.RestaurantRepository;
import com.reservibe.infra.repository.table.TableModelRepository;

import java.util.List;

public class RegisterRestaurantAdapter implements RegisterRestaurantInterface {

    private final RestaurantRepository restaurantRepository;
    private final TableModelRepository tableModelRepository;

    public RegisterRestaurantAdapter(RestaurantRepository restaurantRepository, TableModelRepository tableModelRepository) {
        this.restaurantRepository = restaurantRepository;
        this.tableModelRepository = tableModelRepository;
    }

    @Override
    public Restaurant registerRestaurant(Restaurant restaurant) {
        RestaurantModel restaurantModel = restaurantRepository
                .save(new RestaurantModel(restaurant.getName(),
                        restaurant.getAddress(),
                        restaurant.getPhoneNumber(),
                        restaurant.getDescription(),
                        restaurant.getCuisine(),
                        restaurant.getOpeningHours()));
        restaurant.setId(restaurantModel.getId());
        List<TableModel> tableModels = restaurant.getTables().stream()
                .map(table -> new TableModel(table.getNumber(), table.getSeats(), table.getStatus(), restaurantModel)).toList();
        tableModelRepository.saveAll(tableModels);
        return restaurant;
    }
}
