package com.reservibe.infra.repository.table;

import com.reservibe.infra.model.table.TableModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TableModelRepository extends JpaRepository<TableModel, UUID> {
}
