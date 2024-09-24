package com.reservibe.helper;

import com.reservibe.domain.enums.table.TableStatus;
import com.reservibe.domain.input.table.TableInput;
import com.reservibe.infra.model.table.TableModel;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TableHelper {

    public static TableModel createTableModel(UUID id){

        return new TableModel(id,1,4, TableStatus.FREE);
    }

    public final TableModel createTableModelWithoutId(){

        return new TableModel(1,4, TableStatus.FREE);
    }

    public final TableInput createTableInput(){

        return new TableInput(1,4, TableStatus.FREE);
    }
    public final List<TableInput> createTableInputWithStatus(String status1){
        List<TableInput> tableList = new ArrayList<>();
        TableInput table1 = new TableInput(1,4, TableStatus.valueOf(status1));
        TableInput table2 = new TableInput(2,6, TableStatus.valueOf(status1));
        tableList.add(table1);
        tableList.add(table2);
        return tableList;
    }
}
