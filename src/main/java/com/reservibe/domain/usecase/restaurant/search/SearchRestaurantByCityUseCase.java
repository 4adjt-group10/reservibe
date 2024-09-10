package com.reservibe.domain.usecase.restaurant.search;

import com.reservibe.domain.generic.output.OutputStatus;
import com.reservibe.domain.output.restaurant.RestaurantListOutput;
import com.reservibe.infra.adapter.restaurant.SearchRestaurantService;

public class SearchRestaurantByCityUseCase {

    private final SearchRestaurantService searchRestaurantService;

    public SearchRestaurantByCityUseCase(SearchRestaurantService searchRestaurantService) {
        this.searchRestaurantService = searchRestaurantService;
    }

    public RestaurantListOutput execute(String city) {
        return new RestaurantListOutput(searchRestaurantService.findAllByCity(city),
                new OutputStatus(200, "OK", "Restaurants found successfully"));
    }
}
