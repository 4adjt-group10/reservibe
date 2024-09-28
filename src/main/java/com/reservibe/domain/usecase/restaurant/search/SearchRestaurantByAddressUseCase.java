package com.reservibe.domain.usecase.restaurant.search;

import com.reservibe.domain.entity.restaurant.Address;
import com.reservibe.domain.generic.output.OutputStatus;
import com.reservibe.domain.output.restaurant.RestaurantListOutput;
import com.reservibe.infra.adapter.restaurant.SearchRestaurantAdapter;

import java.util.ArrayList;

public class SearchRestaurantByAddressUseCase {

    private final SearchRestaurantAdapter searchRestaurantAdapter;

    public SearchRestaurantByAddressUseCase(SearchRestaurantAdapter searchRestaurantAdapter) {
        this.searchRestaurantAdapter = searchRestaurantAdapter;
    }

    public RestaurantListOutput execute(Address address) {
        var restaurantList = searchRestaurantAdapter.findAllByAddress(address);
        if(!restaurantList.isEmpty()){
            return new RestaurantListOutput(restaurantList,
                    new OutputStatus(200, "OK", "Restaurants found successfully"));
        }
        return new RestaurantListOutput(new ArrayList<>(),
                new OutputStatus(400, "Bad Request ", "Restaurants not found"));
    }
}
