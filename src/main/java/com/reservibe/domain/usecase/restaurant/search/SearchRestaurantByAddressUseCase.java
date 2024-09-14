package com.reservibe.domain.usecase.restaurant.search;

import com.reservibe.domain.entity.restaurant.Address;
import com.reservibe.domain.generic.output.OutputStatus;
import com.reservibe.domain.output.restaurant.RestaurantListOutput;
import com.reservibe.infra.adapter.restaurant.SearchRestaurantAdapter;

public class SearchRestaurantByAddressUseCase {

    private final SearchRestaurantAdapter searchRestaurantAdapter;

    public SearchRestaurantByAddressUseCase(SearchRestaurantAdapter searchRestaurantAdapter) {
        this.searchRestaurantAdapter = searchRestaurantAdapter;
    }

    //TODO: aprimorar lógica de retorno. Usar retornos como 404, 500 e etc
    public RestaurantListOutput execute(Address address) {
        return new RestaurantListOutput(searchRestaurantAdapter.findAllByAddress(address),
                new OutputStatus(200, "OK", "Restaurants found successfully"));
    }
}
