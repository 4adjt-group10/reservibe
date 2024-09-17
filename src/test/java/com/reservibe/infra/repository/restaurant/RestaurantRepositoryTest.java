package com.reservibe.infra.repository.restaurant;

import com.reservibe.domain.entity.restaurant.Address;
import com.reservibe.domain.entity.restaurant.OpeningHours;
import com.reservibe.domain.enums.retaurant.Cuisine;
import com.reservibe.domain.enums.table.TableStatus;
import com.reservibe.infra.model.restaurant.RestaurantModel;
import com.reservibe.infra.model.table.TableModel;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class RestaurantRepositoryTest {

    @Mock
    private RestaurantRepository restaurantRepository;

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
    void shouldSaveRestaurant(){
        var restaurant = createRestaurant(UUID.randomUUID());

        when(restaurantRepository.save(any(RestaurantModel.class))).thenReturn(restaurant);
        //Act
        var restaurantSaved = restaurantRepository.save(restaurant);
        //validation
        assertThat(restaurantSaved)
                .isNotNull()
                .isEqualTo(restaurant);

        //verifica que o repository foi chamado ao menos 1 vez para salvar algo
        verify(restaurantRepository, times(1)).save(any(RestaurantModel.class));
    }

    @Test
    void shouldListRestaurant(){
        //Arrange
        var id = UUID.randomUUID();
        var restaurant = createRestaurant(id);

        //Define comportamento quando for chamado esse método com o UUID
        when(restaurantRepository.findById(any(UUID.class))).thenReturn(Optional.of(restaurant));

        //Act
        var restaurantRead = restaurantRepository.findById(id);

        //Assert
        assertThat(restaurantRead)
                .isPresent()
                .containsSame(restaurant);

        restaurantRead.ifPresent(rest ->{
            assertThat(rest.getId()).isEqualTo(restaurant.getId());
            assertThat(rest.getName()).isEqualTo(restaurant.getName());
        });

        verify(restaurantRepository, times(1)).findById(any(UUID.class));

    }

    @Test
    void shouldListAllRestaurantsByCuisine(){
        //Arrange
        var listOfRestaurant = Arrays.asList(createRestaurant(UUID.randomUUID()),createRestaurant(UUID.randomUUID()));
        when(restaurantRepository.findAllByCuisine(any(Cuisine.class))).thenReturn(listOfRestaurant);

        //Act
        var listRestaurants = restaurantRepository.findAllByCuisine(Cuisine.ITALIAN);

        //
        assertThat(listRestaurants)
                .isNotNull()
                .hasSize(2);


        verify(restaurantRepository, times(1)).findAllByCuisine(Cuisine.ITALIAN);

    }

    @Test
    void shouldListAllRestaurantsByName(){
        //Arrange
        var restaurant = createRestaurant(UUID.randomUUID());
        when(restaurantRepository.findByName(any(String.class))).thenReturn(Optional.of(restaurant));

        //Act
        var listRestaurants = restaurantRepository.findByName("Restaurante");

        //Assert
        assertThat(listRestaurants)
                .isPresent()
                .containsSame(restaurant);

        listRestaurants.ifPresent(rest ->{
            assertThat(rest.getId()).isEqualTo(restaurant.getId());
            assertThat(rest.getName()).isEqualTo(restaurant.getName());
        });

        verify(restaurantRepository, times(1)).findByName("Restaurante");

    }

    @Test
    void shouldListAllRestaurantsByCity(){
        //Arrange
        var listOfRestaurant = Arrays.asList(createRestaurant(UUID.randomUUID()),createRestaurant(UUID.randomUUID()));
        when(restaurantRepository.findAllByAddress_City(any(String.class))).thenReturn(listOfRestaurant);

        //Act
        var listRestaurants = restaurantRepository.findAllByAddress_City("São Paulo");

        //
        assertThat(listRestaurants)
                .isNotNull()
                .containsAll(listRestaurants)
                .hasSize(2);


        verify(restaurantRepository, times(1)).findAllByAddress_City("São Paulo");

    }

    @Test
    void shouldListAllRestaurantsByAddress(){
        Address address = new Address("street",
                123,
                "neighborhood",
                "São Paulo",
                "state",
                "country",
                "zipCode");
        //Arrange
        var listOfRestaurant = Arrays.asList(createRestaurant(UUID.randomUUID()),createRestaurant(UUID.randomUUID()));
        when(restaurantRepository.findAllByAddress(any(Address.class))).thenReturn(listOfRestaurant);

        //Act
        var listRestaurants = restaurantRepository.findAllByAddress(address);

        //
        assertThat(listRestaurants)
                .isNotNull()
                .containsAll(listRestaurants)
                .hasSize(2);


        verify(restaurantRepository, times(1)).findAllByAddress(address);

    }

    @Test
    void shouldListAllRestaurantsOpeningHours(){
        OpeningHours openingHours = new OpeningHours(DayOfWeek.FRIDAY,LocalTime.now(), LocalTime.now());
        //Arrange
        var listOfRestaurant = Arrays.asList(createRestaurant(UUID.randomUUID()),createRestaurant(UUID.randomUUID()));
        when(restaurantRepository.findAllByOpeningHours(any(OpeningHours.class))).thenReturn(listOfRestaurant);

        //Act
        var listRestaurants = restaurantRepository.findAllByOpeningHours(openingHours);

        //
        assertThat(listRestaurants)
                .isNotNull()
                .containsAll(listRestaurants)
                .hasSize(2);


        verify(restaurantRepository, times(1)).findAllByOpeningHours(openingHours);

    }
//
//    @Test
//    void shouldUpdateRestaurant(){
//        fail("Método não implementado");
//    }

    @Test
    void shouldDeleteRestaurant(){
        var restaurant = createRestaurant(UUID.randomUUID());

        //Define comportamento quando for chamado esse método com o UUID
        doNothing().when(restaurantRepository).delete(any(RestaurantModel.class));

        restaurantRepository.delete(restaurant);

        verify(restaurantRepository, times(1)).delete(any(RestaurantModel.class));

    }

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
