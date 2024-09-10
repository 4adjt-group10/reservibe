package com.reservibe.domain.usecase.restaurant.search;

import com.reservibe.domain.enums.retaurant.Cuisine;
import com.reservibe.domain.generic.output.OutputStatus;
import com.reservibe.domain.output.restaurant.RestaurantListOutput;
import com.reservibe.infra.adapter.restaurant.SearchRestaurantService;

public class SearchRestaurantByCuisineUseCase {

    private final SearchRestaurantService searchRestaurantService;

    public SearchRestaurantByCuisineUseCase(SearchRestaurantService searchRestaurantService) {
        this.searchRestaurantService = searchRestaurantService;
    }

    public RestaurantListOutput execute(Cuisine cuisine) {
        return new RestaurantListOutput(searchRestaurantService.findAllByCuisine(cuisine),
                new OutputStatus(200, "OK", "Restaurants found successfully"));
    }
}
