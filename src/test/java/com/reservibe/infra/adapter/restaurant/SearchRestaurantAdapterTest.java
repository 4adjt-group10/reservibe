package com.reservibe.infra.adapter.restaurant;

import com.reservibe.domain.entity.restaurant.Address;
import com.reservibe.domain.entity.restaurant.OpeningHours;
import com.reservibe.domain.entity.restaurant.Restaurant;
import com.reservibe.domain.entity.table.Table;
import com.reservibe.domain.enums.retaurant.Cuisine;
import com.reservibe.domain.enums.table.TableStatus;
import com.reservibe.infra.model.restaurant.RestaurantModel;
import com.reservibe.infra.model.table.TableModel;
import com.reservibe.infra.repository.restaurant.RestaurantRepository;
import com.reservibe.infra.repository.table.TableModelRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.*;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.*;

import static org.mockito.ArgumentMatchers.any;

public class SearchRestaurantAdapterTest {

    @Mock
    private RestaurantRepository restaurantRepository;

    private SearchRestaurantAdapter adapter;

    AutoCloseable mock;

    @BeforeEach
    void setup(){
        mock = MockitoAnnotations.openMocks(this);
        adapter = new SearchRestaurantAdapter(restaurantRepository);
    };

    @AfterEach
    void tearDown() throws Exception {
        mock.close();
    }

    @Test
    void shouldSearchByName(){
        var id = UUID.randomUUID();
        var restaurant = createRestaurant(id);

        when(restaurantRepository.findByName(any(String.class)))
                .thenReturn(Optional.of(restaurant));


        var restaurantRead = adapter.findRestaurantByName("Restaurante");

        assertThat(restaurantRead.getId()).isEqualTo(restaurant.getId());
        assertThat(restaurantRead.getName()).isEqualTo(restaurant.getName());
        assertThat(restaurantRead.getCuisine()).isEqualTo(restaurant.getCuisine());
        assertThat(restaurantRead.getDescription()).isEqualTo(restaurant.getDescription());
        assertThat(restaurantRead.getPhoneNumber()).isEqualTo(restaurant.getPhoneNumber());
        verify(restaurantRepository, times(1)).findByName(any(String.class));

    }

    @Test
    void shouldSearchAllRestaurantsByAddress(){
        Address address = new Address("street",
                123,
                "neighborhood",
                "São Paulo",
                "state",
                "country",
                "zipCode");

        var listOfRestaurant = Arrays.asList(createRestaurant(UUID.randomUUID()),createRestaurant(UUID.randomUUID()));

        when(restaurantRepository.findAllByAddress(any(Address.class)))
                .thenReturn(listOfRestaurant);


        var restaurantRead = adapter.findAllByAddress(address);

        assertThat(restaurantRead)
                .isNotNull()
                .hasSize(2);

        verify(restaurantRepository, times(1)).findAllByAddress(any(Address.class));


    }

    @Test
    void shouldSearchAllRestaurantsByCity(){

        var listOfRestaurant = Arrays.asList(createRestaurant(UUID.randomUUID()),createRestaurant(UUID.randomUUID()));

        when(restaurantRepository.findAllByAddress_City(any(String.class)))
                .thenReturn(listOfRestaurant);


        var restaurantRead = adapter.findAllByCity("São Paulo");

        assertThat(restaurantRead)
                .isNotNull()
                .hasSize(2);

        verify(restaurantRepository, times(1)).findAllByAddress_City(any(String.class));


    }

    @Test
    void shouldSearchAllRestaurantsByCusine(){
        var listOfRestaurant = Arrays.asList(createRestaurant(UUID.randomUUID()),createRestaurant(UUID.randomUUID()));

        when(restaurantRepository.findAllByCuisine(any(Cuisine.class)))
                .thenReturn(listOfRestaurant);


        var restaurantRead = adapter.findAllByCuisine(Cuisine.ITALIAN);

        assertThat(restaurantRead)
                .isNotNull()
                .hasSize(2);

        verify(restaurantRepository, times(1)).findAllByCuisine(any(Cuisine.class));


    }

    //Não vai ter por Opening Hours?

//    @Test
//    void shouldSearchAllRestaurantsByOpeningHours(){
//        OpeningHours openingHours = new OpeningHours(DayOfWeek.FRIDAY,LocalTime.now(), LocalTime.now());
//
//
//        var listOfRestaurant = Arrays.asList(createRestaurant(UUID.randomUUID()),createRestaurant(UUID.randomUUID()));
//
//        when(restaurantRepository.findAllByOpeningHours(any(OpeningHours.class)))
//                .thenReturn(listOfRestaurant);
//
//
//        var restaurantRead = adapter.find(Cuisine.ITALIAN);
//
//        assertThat(restaurantRead)
//                .isNotNull()
//                .hasSize(2);
//
//        verify(restaurantRepository, times(1)).findAllByOpeningHours(any(OpeningHours.class));
//
//
//    }

    private RestaurantModel createRestaurant(UUID id){
        List<OpeningHours>openingHours = new ArrayList<>();
        OpeningHours openingHours1 = new OpeningHours(DayOfWeek.MONDAY, LocalTime.now(),LocalTime.now());
        OpeningHours openingHours2 = new OpeningHours(DayOfWeek.FRIDAY, LocalTime.now(),LocalTime.now());
        OpeningHours openingHours3 = new OpeningHours(DayOfWeek.SATURDAY, LocalTime.now(),LocalTime.now());
        openingHours.add(openingHours2);
        openingHours.add(openingHours3);
        openingHours.add(openingHours1);
        List<TableModel> tableModels = new ArrayList<>();
        tableModels.add(createTable());
        var addres = new Address("street",
                123,
                "neighborhood",
                "São Paulo",
                "state",
                "country",
                "zipCode");

        return new RestaurantModel(id,
                "Restaurante",
                addres,
                "1187652435",
                "Restaurante italiano",
                Cuisine.ITALIAN,
                openingHours,tableModels);
    }

    private TableModel createTable(){

        return new TableModel(1,4, TableStatus.FREE);
    }

}
