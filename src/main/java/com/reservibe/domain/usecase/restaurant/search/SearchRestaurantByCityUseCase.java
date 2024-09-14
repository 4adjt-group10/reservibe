package com.reservibe.domain.usecase.restaurant.search;

import com.reservibe.domain.generic.output.OutputStatus;
import com.reservibe.domain.output.restaurant.RestaurantListOutput;
import com.reservibe.infra.adapter.restaurant.SearchRestaurantAdapter;

public class SearchRestaurantByCityUseCase {

    private final SearchRestaurantAdapter searchRestaurantAdapter;

    public SearchRestaurantByCityUseCase(SearchRestaurantAdapter searchRestaurantAdapter) {
        this.searchRestaurantAdapter = searchRestaurantAdapter;
    }

    public RestaurantListOutput execute(String city) {
        return new RestaurantListOutput(searchRestaurantAdapter.findAllByCity(city),
                new OutputStatus(200, "OK", "Restaurants found successfully"));
    }
}
