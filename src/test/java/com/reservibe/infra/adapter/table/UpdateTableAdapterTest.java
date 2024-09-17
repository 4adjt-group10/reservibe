package com.reservibe.infra.adapter.table;

import com.reservibe.domain.entity.restaurant.Restaurant;
import com.reservibe.domain.enums.table.TableStatus;
import com.reservibe.infra.model.restaurant.RestaurantModel;
import com.reservibe.infra.model.table.TableModel;
import com.reservibe.infra.repository.table.TableModelRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class UpdateTableAdapterTest {

    @Mock
    private TableModelRepository tableModelRepository;

    @InjectMocks
    private UpdateTableAdapter adapter;

    AutoCloseable mock;

    @BeforeEach
    void setup(){
        mock = MockitoAnnotations.openMocks(this);
        adapter = new UpdateTableAdapter(tableModelRepository);
    };

    @AfterEach
    void tearDown() throws Exception {
        mock.close();
    }

    @Test
    void shouldSearchByIdAndStatus(){
        var id = UUID.randomUUID();
        var table = createTable(id);

        var newTable = table;
        newTable.setStatus(TableStatus.OCCUPIED);

        when(tableModelRepository.findByIdAndStatus(any(UUID.class),any(TableStatus.class)))
                .thenReturn(Optional.of(table));
        when(tableModelRepository.save(newTable))
                .thenAnswer(i -> i.getArgument(0)); //essa chamada acessa um método e verifica dentro dele as informações (deve receber um professional e retornar esse professional)

        adapter.updateTableWithStatus(id,TableStatus.FREE);

        verify(tableModelRepository,times(1)).save(any(TableModel.class));

    }

    private TableModel createTable(UUID id){

        return new TableModel(id,1,4, TableStatus.FREE);
    }
}
