package com.reservibe.helper;

import com.reservibe.domain.enums.table.TableStatus;
import com.reservibe.infra.model.table.TableModel;

import java.util.UUID;

public class TableHelper {

    public static TableModel createTableModel(UUID id){

        return new TableModel(id,1,4, TableStatus.FREE);
    }

    public final TableModel createTableModelWithoutId(){

        return new TableModel(1,4, TableStatus.FREE);
    }
}
