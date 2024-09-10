package com.reservibe.domain.input.table;

import com.reservibe.domain.enums.table.TableStatus;

public record TableInput(Integer number, int seats, TableStatus status) {
}
