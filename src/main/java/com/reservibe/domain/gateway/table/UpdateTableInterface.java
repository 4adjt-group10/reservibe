package com.reservibe.domain.gateway.table;

import com.reservibe.domain.enums.table.TableStatus;

import java.util.UUID;

public interface UpdateTableInterface {

    void updateTableWithStatus(UUID tableId, TableStatus tableStatus);
}
