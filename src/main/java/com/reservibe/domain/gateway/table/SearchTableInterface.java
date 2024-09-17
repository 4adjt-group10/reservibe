package com.reservibe.domain.gateway.table;

import com.reservibe.domain.entity.table.Table;

import java.util.UUID;

public interface SearchTableInterface {

    Table getTableByIdAndStatusIsFree(UUID id);
}
