package com.reservibe.domain.usecase.restaurant.register;

import com.reservibe.domain.entity.restaurant.Address;
import com.reservibe.domain.entity.restaurant.OpeningHours;
import com.reservibe.domain.entity.restaurant.Restaurant;
import com.reservibe.domain.entity.table.Table;
import com.reservibe.domain.enums.retaurant.Cuisine;
import com.reservibe.domain.enums.table.TableStatus;
import com.reservibe.domain.input.restaurant.RestaurantInput;
import com.reservibe.domain.input.table.TableInput;
import com.reservibe.helper.TableHelper;
import com.reservibe.infra.adapter.restaurant.RegisterRestaurantAdapter;
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

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


class RegisterRestaurantUseCaseTest {

    @Mock
    private  RegisterRestaurantAdapter registerRestaurantAdapter;

    @InjectMocks
    private RegisterRestaurantUseCase registerRestaurantUseCase;

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
        when(registerRestaurantAdapter.registerRestaurant(any(Restaurant.class))).thenReturn(createRestaurant());
        registerRestaurantUseCase.execute(createRestaurantInput());
        verify(registerRestaurantAdapter, times(1)).registerRestaurant(any(Restaurant.class));
    }

    TableHelper helper = new TableHelper();

    public final RestaurantInput createRestaurantInput(){
        List<OpeningHours> openingHours = new ArrayList<>();
        OpeningHours openingHours1 = new OpeningHours(DayOfWeek.MONDAY, LocalTime.now(),LocalTime.now());
        OpeningHours openingHours2 = new OpeningHours(DayOfWeek.FRIDAY, LocalTime.now(),LocalTime.now());
        OpeningHours openingHours3 = new OpeningHours(DayOfWeek.SATURDAY, LocalTime.now(),LocalTime.now());
        openingHours.add(openingHours2);
        openingHours.add(openingHours3);
        openingHours.add(openingHours1);
        List<TableInput> tableInputs = new ArrayList<>();
        tableInputs.add(helper.createTableInput());
        var addres = new Address("street",
                123,
                "neighborhood",
                "São Paulo",
                "state",
                "country",
                "zipCode");

        return new RestaurantInput(
                "Restaurante",
                addres,
                "1187652435",
                "Restaurante italiano",
                Cuisine.ITALIAN,
                openingHours,tableInputs);
    }

    private Table createTable(){

        return new Table(1,4, TableStatus.FREE);
    }

    private Restaurant createRestaurant(){
        List<OpeningHours>openingHours = new ArrayList<>();
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

}