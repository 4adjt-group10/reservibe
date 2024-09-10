package com.reservibe.domain.usecase.restaurant.search;

import com.reservibe.domain.generic.output.OutputStatus;
import com.reservibe.domain.output.restaurant.RestaurantOutput;
import com.reservibe.infra.adapter.restaurant.SearchRestaurantService;

public class SearchRestaurantByCityUseCase {

    private final SearchRestaurantService searchRestaurantService;

    public SearchRestaurantByCityUseCase(SearchRestaurantService searchRestaurantService) {
        this.searchRestaurantService = searchRestaurantService;
    }

    public RestaurantOutput execute(String city) {
        return new RestaurantOutput(searchRestaurantService.findAllByCity(city),
                new OutputStatus(200, "OK", "Restaurants found successfully"));
    }
}
