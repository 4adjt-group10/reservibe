package com.reservibe.infra.repository.table;

import com.reservibe.domain.enums.table.TableStatus;
import com.reservibe.infra.model.table.TableModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TableModelRepository extends JpaRepository<TableModel, UUID> {
    Optional<TableModel> findByIdAndStatus(UUID id, TableStatus status);
}
