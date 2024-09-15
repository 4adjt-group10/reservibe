package com.reservibe.domain.usecase.restaurant.search;

import com.reservibe.domain.enums.retaurant.Cuisine;
import com.reservibe.domain.generic.output.OutputStatus;
import com.reservibe.domain.output.restaurant.RestaurantListOutput;
import com.reservibe.infra.adapter.restaurant.SearchRestaurantAdapter;

public class SearchRestaurantByCuisineUseCase {

    private final SearchRestaurantAdapter searchRestaurantAdapter;

    public SearchRestaurantByCuisineUseCase(SearchRestaurantAdapter searchRestaurantAdapter) {
        this.searchRestaurantAdapter = searchRestaurantAdapter;
    }

    public RestaurantListOutput execute(Cuisine cuisine) {
        return new RestaurantListOutput(searchRestaurantAdapter.findAllByCuisine(cuisine),
                new OutputStatus(200, "OK", "Restaurants found successfully"));
    }
}
