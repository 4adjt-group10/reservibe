package com.reservibe.infra.repository.table;


import com.reservibe.domain.enums.table.TableStatus;
import com.reservibe.infra.model.table.TableModel;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class TableModelRepositoryTest {

    @Mock
    private TableModelRepository tableModelRepository;

    AutoCloseable openMocks;


    @BeforeEach
    void setup(){
        openMocks = MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    void tearDown() throws Exception {
        openMocks.close();
    }

    @Test
    void shouldSaveTable(){
        var id = UUID.randomUUID();
        var table = createTable(id);
        when(tableModelRepository.save(any(TableModel.class))).thenReturn(table);
        //Act
        var tableSaved = tableModelRepository.save(table);
        //validation
        assertThat(tableSaved)
                .isNotNull()
                .isEqualTo(table);

        //verifica que o repository foi chamado ao menos 1 vez para salvar algo
        verify(tableModelRepository, times(1)).save(any(TableModel.class));

    }

    @Test
    void shouldListTableByIdAnsStatus(){
        //Arrange
        var id = UUID.randomUUID();
        var table = createTable(id);
        var status = table.getStatus();
        //var listOfTables = Arrays.asList(createTable(id),createTable());
        when(tableModelRepository.findByIdAndStatus(any(UUID.class),any(TableStatus.class))).thenReturn(Optional.of(table));
        //Act
        var tableRead = tableModelRepository.findByIdAndStatus(id, status);

        //
        assertThat(tableRead)
                .isPresent()
                .containsSame(table);

        tableRead.ifPresent(tb ->{
            assertThat(tb.getId()).isEqualTo(table.getId());
            assertThat(tb.getStatus()).isEqualTo(table.getStatus());
            assertThat(tb.getNumber()).isEqualTo(table.getNumber());
            assertThat(tb.getSeats()).isEqualTo(table.getSeats());
        });

        verify(tableModelRepository, times(1)).findByIdAndStatus(any(UUID.class),any(TableStatus.class));

    }

    @Test
    void shouldDeleteTable(){
        var id = UUID.randomUUID();
        var table = createTable(id);

        //Define comportamento quando for chamado esse método com o UUID
        doNothing().when(tableModelRepository).delete(any(TableModel.class));

        tableModelRepository.delete(table);

        verify(tableModelRepository, times(1)).delete(any(TableModel.class));

    }


    private TableModel createTable(UUID id){

        return new TableModel(id,1,4, TableStatus.FREE);
    }


}
