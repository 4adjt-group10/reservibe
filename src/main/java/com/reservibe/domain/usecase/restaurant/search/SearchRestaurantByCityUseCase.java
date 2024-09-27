package com.reservibe.domain.usecase.restaurant.search;

import com.reservibe.domain.generic.output.OutputStatus;
import com.reservibe.domain.output.restaurant.RestaurantListOutput;
import com.reservibe.infra.adapter.restaurant.SearchRestaurantAdapter;

import java.util.ArrayList;

public class SearchRestaurantByCityUseCase {

    private final SearchRestaurantAdapter searchRestaurantAdapter;

    public SearchRestaurantByCityUseCase(SearchRestaurantAdapter searchRestaurantAdapter) {
        this.searchRestaurantAdapter = searchRestaurantAdapter;
    }

    public RestaurantListOutput execute(String city) {
        var restaurantList = searchRestaurantAdapter.findAllByCity(city);
        if(!restaurantList.isEmpty()){
            return new RestaurantListOutput(restaurantList,
                    new OutputStatus(200, "OK", "Restaurants found successfully"));
        }
        return new RestaurantListOutput(new ArrayList<>(),
                new OutputStatus(400, "Bad Request ", "Restaurants not found"));
    }

}
