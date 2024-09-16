package com.reservibe.infra.repository.adapter;

import com.reservibe.domain.entity.restaurant.Address;
import com.reservibe.domain.entity.restaurant.Restaurant;
import com.reservibe.domain.entity.table.Table;
import com.reservibe.domain.enums.retaurant.Cuisine;
import com.reservibe.domain.enums.table.TableStatus;
import com.reservibe.infra.adapter.restaurant.RegisterRestaurantAdapter;
import com.reservibe.infra.model.restaurant.RestaurantModel;
import com.reservibe.infra.repository.restaurant.RestaurantRepository;
import com.reservibe.infra.repository.table.TableModelRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class RestaurantRegisterAdapter {

    @Mock
    private RestaurantRepository restaurantRepository;

    @Mock
    private TableModelRepository tableModelRepository;

    private RegisterRestaurantAdapter adapter;

    //private RegisterRestaurantUseCase register;

    AutoCloseable mock;

    @BeforeEach
    void setup(){
        mock = MockitoAnnotations.openMocks(this);
        adapter = new RegisterRestaurantAdapter(restaurantRepository, tableModelRepository);
    };

    @AfterEach
    void tearDown() throws Exception {
        mock.close();
    }

    @Test
    void shouldSaveRestaurant(){

        var restaurant = createRestaurant(UUID.randomUUID());

        when(restaurantRepository.save(any(RestaurantModel.class)))
                .thenAnswer(i -> i.getArgument(0)); //essa chamada acessa um método e verifica dentro dele as informações (deve receber um professional e retornar esse professional)

        var resturantCreated = adapter.registerRestaurant(restaurant);

    }

    private Restaurant createRestaurant(UUID id){
        ArrayList lista = new ArrayList();
        lista.add(13);
        lista.add(14);
        lista.add(15);

        return new Restaurant(id, "Restaurante", new Address("street",
                        123,
                        "neighborhood",
                        "city",
                        "state",
                        "country",
                        "zipCode"),
                "1187652435",
                "Restaurante italiano",
                Cuisine.ITALIAN,
                lista,
                List.of(createTable()));

    }

    private Table createTable(){
        return new Table(1,4, TableStatus.FREE);
    }
}
