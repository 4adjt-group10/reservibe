package com.reservibe.domain.usecase.restaurant.search;

import com.reservibe.domain.generic.output.OutputStatus;
import com.reservibe.domain.output.restaurant.RestaurantOutput;
import com.reservibe.infra.adapter.restaurant.SearchRestaurantAdapter;

public class SearchRestaurantByNameUseCase {

    private final SearchRestaurantAdapter searchRestaurantAdapter;

    public SearchRestaurantByNameUseCase(SearchRestaurantAdapter searchRestaurantAdapter) {
        this.searchRestaurantAdapter = searchRestaurantAdapter;
    }

    public RestaurantOutput execute(String name) {
        return new RestaurantOutput(searchRestaurantAdapter.findRestaurantByName(name),
                new OutputStatus(200, "OK", "Restaurant found successfully"));
    }
}
