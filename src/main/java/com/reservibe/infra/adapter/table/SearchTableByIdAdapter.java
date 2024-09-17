package com.reservibe.infra.adapter.table;

import com.reservibe.domain.entity.table.Table;
import com.reservibe.domain.enums.table.TableStatus;
import com.reservibe.domain.gateway.table.SearchTableInterface;
import com.reservibe.infra.repository.table.TableModelRepository;
import jakarta.persistence.EntityNotFoundException;

import java.util.UUID;

public class SearchTableByIdAdapter implements SearchTableInterface {

    private final TableModelRepository tableModelRepository;

    public SearchTableByIdAdapter(TableModelRepository tableModelRepository) {
        this.tableModelRepository = tableModelRepository;
    }

    @Override
    public Table getTableByIdAndStatusIsFree(UUID id) {
       var tableModel =  tableModelRepository.findByIdAndStatus(id, TableStatus.FREE)
                .orElseThrow(()->new EntityNotFoundException("Table not Available"));
        return new Table(tableModel.getId(),tableModel.getNumber(),tableModel.getSeats(),tableModel.getStatus());
    }
}

