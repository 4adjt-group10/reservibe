package com.reservibe.infra.adapter.table;

import com.reservibe.domain.enums.table.TableStatus;
import com.reservibe.domain.gateway.table.UpdateTableInterface;
import com.reservibe.infra.model.table.TableModel;
import com.reservibe.infra.repository.table.TableModelRepository;

import java.util.UUID;

public class UpdateTableAdapter implements UpdateTableInterface {

    private final TableModelRepository tableModelRepository;

    public UpdateTableAdapter(TableModelRepository tableModelRepository) {
        this.tableModelRepository = tableModelRepository;
    }

    @Override
    public void updateTableWithStatus(UUID tableId, TableStatus tableStatus) {
        TableModel model = tableModelRepository.findById(tableId)
                .orElseThrow(() -> new RuntimeException("Table not found"));
        model.setStatus(tableStatus);
        this.tableModelRepository.save(model);
    }
}
