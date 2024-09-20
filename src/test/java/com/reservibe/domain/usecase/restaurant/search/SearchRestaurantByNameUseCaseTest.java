package com.reservibe.domain.usecase.restaurant.search;

import com.reservibe.domain.entity.restaurant.Address;
import com.reservibe.domain.entity.restaurant.OpeningHours;
import com.reservibe.domain.entity.restaurant.Restaurant;
import com.reservibe.domain.entity.table.Table;
import com.reservibe.domain.enums.retaurant.Cuisine;
import com.reservibe.domain.enums.table.TableStatus;
import com.reservibe.domain.output.restaurant.RestaurantOutput;
import com.reservibe.infra.adapter.restaurant.SearchRestaurantAdapter;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class SearchRestaurantByNameUseCaseTest {

    @Mock
    private SearchRestaurantAdapter searchRestaurantAdapter;

    @InjectMocks
    private SearchRestaurantByNameUseCase searchRestaurantByNameUseCase;

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
    void execute() {
        searchRestaurantByNameUseCase.execute("Restaurant");
        verify(searchRestaurantAdapter, times(1)).findRestaurantByName("Restaurant");
    }

    @Test
    void sucessSearchName() {

        when(searchRestaurantAdapter.findRestaurantByName("Restaurante")).thenReturn(createRestaurant());

        RestaurantOutput result = searchRestaurantByNameUseCase.execute("Restaurante");
        assertThat(result).isNotNull();
        assertThat(result.getBody().getName()).isEqualTo("Restaurante");
    }

    @Test
    void SearchNameNotContent() {

        when(searchRestaurantAdapter.findRestaurantByName("Restaurante")).thenReturn(createRestaurant());

        RestaurantOutput result = searchRestaurantByNameUseCase.execute("Coco Verde");
        assertNull(result.getBody());
    }

    private Restaurant createRestaurant(){
        List<OpeningHours> openingHours = new ArrayList<>();
        OpeningHours openingHours1 = new OpeningHours(DayOfWeek.MONDAY, LocalTime.now(),LocalTime.now());
        OpeningHours openingHours2 = new OpeningHours(DayOfWeek.FRIDAY, LocalTime.now(),LocalTime.now());
        OpeningHours openingHours3 = new OpeningHours(DayOfWeek.SATURDAY, LocalTime.now(),LocalTime.now());
        openingHours.add(openingHours2);
        openingHours.add(openingHours3);
        openingHours.add(openingHours1);
        List<Table> tables = new ArrayList<>();
        tables.add(createTable());
        var addres = new Address("street",
                123,
                "neighborhood",
                "city",
                "state",
                "country",
                "zipCode");

        return new Restaurant(UUID.randomUUID(),
                "Restaurante",
                addres,
                "1187652435",
                "Restaurante italiano",
                Cuisine.ITALIAN,
                openingHours,tables);
    }
    private Table createTable(){

        return new Table(1,4, TableStatus.FREE);
    }
}