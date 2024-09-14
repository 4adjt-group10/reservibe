package com.reservibe.domain.usecase.table;

import com.reservibe.infra.adapter.table.SearchTableByIdAdapter;

public class FindTableUseCase {
    private final SearchTableByIdAdapter searchTableByIdAdapter;


    public FindTableUseCase(SearchTableByIdAdapter searchTableByIdAdapter) {
        this.searchTableByIdAdapter = searchTableByIdAdapter;
    }
}
