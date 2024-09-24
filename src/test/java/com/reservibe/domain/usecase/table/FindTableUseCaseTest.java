package com.reservibe.domain.usecase.table;

import com.reservibe.infra.adapter.table.SearchTableByIdAdapter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;

public class FindTableUseCaseTest {
    @Mock
    private SearchTableByIdAdapter searchTableByIdAdapter;
    @Mock
    private FindTableUseCase findTableUseCase;


    @BeforeEach
    void setUp() {
        searchTableByIdAdapter = Mockito.mock(SearchTableByIdAdapter.class);
        findTableUseCase = new FindTableUseCase(searchTableByIdAdapter);
    }



    @Test
    void testFindTableUseCaseCreation() {
        assertNotNull(findTableUseCase);
    }
}