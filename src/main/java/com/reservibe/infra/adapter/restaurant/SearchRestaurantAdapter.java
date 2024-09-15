package com.reservibe.infra.adapter.restaurant;

import com.reservibe.domain.entity.restaurant.Address;
import com.reservibe.domain.entity.restaurant.Restaurant;
import com.reservibe.domain.entity.table.Table;
import com.reservibe.domain.enums.retaurant.Cuisine;
import com.reservibe.domain.enums.table.TableStatus;
import com.reservibe.domain.gateway.restaurant.SearchRestaurantInterface;
import com.reservibe.infra.repository.restaurant.RestaurantRepository;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;

import static com.reservibe.domain.enums.table.TableStatus.FREE;

public class SearchRestaurantAdapter implements SearchRestaurantInterface {

    private final RestaurantRepository restaurantRepository;

    public SearchRestaurantAdapter(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }
    //TODO: Dividir métodos em adapters específicos?
    @Override
    public Restaurant findRestaurantByName(String name) {
        return restaurantRepository.findByName(name).map(restaurantModel ->
                new Restaurant(restaurantModel.getId(),
                        restaurantModel.getName(),
                        restaurantModel.getAddress(),
                        restaurantModel.getPhoneNumber(),
                        restaurantModel.getDescription(),
                        restaurantModel.getCuisine(),
                        restaurantModel.getOpeningHours(), restaurantModel.getTables().stream()
                        .filter(t -> t.getStatus().equals(FREE))
                        .map(t -> new Table(t.getId(),t.getNumber(), t.getSeats(), t.getStatus())).toList())
        ).orElseThrow(() -> new EntityNotFoundException("Restaurant not found"));
    }

    @Override
    public List<Restaurant> findAllByAddress(Address address) {
        return restaurantRepository.findAllByAddress(address).stream().map(restaurantModel ->
                new Restaurant(restaurantModel.getId(),
                        restaurantModel.getName(),
                        restaurantModel.getAddress(),
                        restaurantModel.getPhoneNumber(),
                        restaurantModel.getDescription(),
                        restaurantModel.getCuisine(),
                        restaurantModel.getOpeningHours(), restaurantModel.getTables().stream()
                        .filter(t -> t.getStatus().equals(FREE))
                        .map(t -> new Table(t.getNumber(), t.getSeats(), t.getStatus())).toList())
        ).toList();
    }

    @Override
    public List<Restaurant> findAllByCity(String city) {
        return restaurantRepository.findAllByAddress_City(city).stream().map(restaurantModel ->
                new Restaurant(restaurantModel.getId(),
                        restaurantModel.getName(),
                        restaurantModel.getAddress(),
                        restaurantModel.getPhoneNumber(),
                        restaurantModel.getDescription(),
                        restaurantModel.getCuisine(),
                        restaurantModel.getOpeningHours(),
                        restaurantModel.getTables().stream()
                                .filter(t -> t.getStatus().equals(FREE))
                        .map(t -> new Table(t.getNumber(), t.getSeats(), t.getStatus())).toList())
        ).toList();
    }

    @Override
    public List<Restaurant> findAllByCuisine(Cuisine cuisine) {
        return restaurantRepository.findAllByCuisine(cuisine).stream().map(restaurantModel ->
                new Restaurant(restaurantModel.getId(),
                        restaurantModel.getName(),
                        restaurantModel.getAddress(),
                        restaurantModel.getPhoneNumber(),
                        restaurantModel.getDescription(),
                        restaurantModel.getCuisine(),
                        restaurantModel.getOpeningHours(),
                        restaurantModel.getTables().stream()
                                .filter(t -> t.getStatus().equals(FREE))
                        .map(t -> new Table(t.getNumber(), t.getSeats(), t.getStatus())).toList())
        ).toList();
    }
}
