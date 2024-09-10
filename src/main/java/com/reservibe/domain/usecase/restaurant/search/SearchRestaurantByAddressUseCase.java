package com.reservibe.domain.usecase.restaurant.search;

import com.reservibe.domain.entity.restaurant.Address;
import com.reservibe.domain.generic.output.OutputStatus;
import com.reservibe.domain.output.restaurant.RestaurantOutput;
import com.reservibe.infra.adapter.restaurant.SearchRestaurantService;

public class SearchRestaurantByAddressUseCase {

    private final SearchRestaurantService searchRestaurantService;

    public SearchRestaurantByAddressUseCase(SearchRestaurantService searchRestaurantService) {
        this.searchRestaurantService = searchRestaurantService;
    }

    public RestaurantOutput execute(Address address) {
        return new RestaurantOutput(searchRestaurantService.findAllByAddress(address),
                new OutputStatus(200, "OK", "Restaurants found successfully"));
    }
}
