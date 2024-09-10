package com.reservibe.domain.usecase.restaurant.search;

import com.reservibe.domain.enums.retaurant.Cuisine;
import com.reservibe.domain.generic.output.OutputStatus;
import com.reservibe.domain.output.restaurant.RestaurantOutput;
import com.reservibe.infra.adapter.restaurant.SearchRestaurantService;

public class SearchRestaurantByCuisineUseCase {

    private final SearchRestaurantService searchRestaurantService;

    public SearchRestaurantByCuisineUseCase(SearchRestaurantService searchRestaurantService) {
        this.searchRestaurantService = searchRestaurantService;
    }

    public RestaurantOutput execute(Cuisine cuisine) {
        return new RestaurantOutput(searchRestaurantService.findAllByCuisine(cuisine),
                new OutputStatus(200, "OK", "Restaurants found successfully"));
    }
}
