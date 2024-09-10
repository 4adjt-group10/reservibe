package com.reservibe.domain.gateway.restaurant;

import com.reservibe.domain.entity.restaurant.Address;
import com.reservibe.domain.entity.restaurant.Restaurant;
import com.reservibe.domain.enums.retaurant.Cuisine;

import java.util.List;

public interface SearchRestaurantInterface {

    Restaurant findRestaurantByName(String name);

    List<Restaurant> findAllByAddress(Address address);

    List<Restaurant> findAllByCity(String city);

    List<Restaurant> findAllByCuisine(Cuisine cuisine);
}
