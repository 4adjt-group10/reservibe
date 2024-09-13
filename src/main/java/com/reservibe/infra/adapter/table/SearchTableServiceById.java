package com.reservibe.infra.adapter.table;

import com.reservibe.infra.model.table.TableModel;
import com.reservibe.infra.repository.table.TableModelRepository;

import java.util.UUID;

public class SearchTableServiceById {
    private final TableModelRepository tableModelRepository;

    public SearchTableServiceById(TableModelRepository tableModelRepository) {
        this.tableModelRepository = tableModelRepository;
    }

    public TableModel getTable(UUID id) {
        return tableModelRepository.findById(id).get();
    }
}
