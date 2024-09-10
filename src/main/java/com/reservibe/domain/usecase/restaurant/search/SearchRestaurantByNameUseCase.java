package com.reservibe.domain.usecase.restaurant.search;

import com.reservibe.domain.generic.output.OutputStatus;
import com.reservibe.domain.output.restaurant.RestaurantOutput;
import com.reservibe.infra.adapter.restaurant.SearchRestaurantService;

public class SearchRestaurantByNameUseCase {

    private final SearchRestaurantService searchRestaurantService;

    public SearchRestaurantByNameUseCase(SearchRestaurantService searchRestaurantService) {
        this.searchRestaurantService = searchRestaurantService;
    }

    public RestaurantOutput execute(String name) {
        return new RestaurantOutput(searchRestaurantService.findRestaurantByName(name),
                new OutputStatus(200, "OK", "Restaurant found successfully"));
    }
}
