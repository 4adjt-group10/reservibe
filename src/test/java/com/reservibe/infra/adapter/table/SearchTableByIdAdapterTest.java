package com.reservibe.infra.adapter.table;

import com.reservibe.domain.enums.table.TableStatus;
import com.reservibe.infra.adapter.restaurant.SearchRestaurantAdapter;
import com.reservibe.infra.model.table.TableModel;
import com.reservibe.infra.repository.table.TableModelRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class SearchTableByIdAdapterTest {

    @Mock
    private TableModelRepository tableModelRepository;

    private SearchTableByIdAdapter adapter;

    AutoCloseable mock;

    @BeforeEach
    void setup(){
        mock = MockitoAnnotations.openMocks(this);
        adapter = new SearchTableByIdAdapter(tableModelRepository);
    };

    @AfterEach
    void tearDown() throws Exception {
        mock.close();
    }

    @Test
    void shouldSearchByIdAndStatus(){
        var id = UUID.randomUUID();
        var table = createTable(id);

        when(tableModelRepository.findByIdAndStatus(any(UUID.class),any(TableStatus.class)))
                .thenReturn(Optional.of(table));


        var tableRead = adapter.getTableByIdAndStatusIsFree(id);

        assertThat(tableRead.getId()).isEqualTo(table.getId());
        assertThat(tableRead.getStatus()).isEqualTo(table.getStatus());
        assertThat(tableRead.getNumber()).isEqualTo(table.getNumber());
        assertThat(tableRead.getSeats()).isEqualTo(table.getSeats());
        assertThat(tableRead.getRestaurant()).isEqualTo(table.getRestaurant());
        verify(tableModelRepository, times(1)).findByIdAndStatus(any(UUID.class),any(TableStatus.class));

    }

    private TableModel createTable(UUID id){

        return new TableModel(id,1,4, TableStatus.FREE);
    }
}
