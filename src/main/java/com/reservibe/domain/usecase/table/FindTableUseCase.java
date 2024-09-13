package com.reservibe.domain.usecase.table;

import com.reservibe.infra.adapter.restaurant.SearchRestaurantService;
import com.reservibe.infra.adapter.table.SearchTableServiceById;

public class FindTableUseCase {
    private final SearchTableServiceById searchTableServiceById;


    public FindTableUseCase(SearchTableServiceById searchTableServiceById) {
        this.searchTableServiceById = searchTableServiceById;
    }
}
