package com.reservibe.infra.repository.restaurant;

import com.reservibe.domain.entity.restaurant.Address;
import com.reservibe.domain.entity.restaurant.OpeningHours;
import com.reservibe.domain.enums.retaurant.Cuisine;
import com.reservibe.domain.enums.table.TableStatus;
import com.reservibe.helper.RestaurantHelper;
import com.reservibe.helper.TableHelper;
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

    RestaurantHelper helper = new RestaurantHelper();


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
        var restaurant = helper.createRestaurant(UUID.randomUUID());

        when(restaurantRepository.save(any(RestaurantModel.class))).thenReturn(restaurant);
        //Act
        var restaurantSaved = restaurantRepository.save(restaurant);
        //validation
        assertThat(restaurantSaved)
                .isNotNull()
                .isEqualTo(restaurant);


        verify(restaurantRepository, times(1)).save(any(RestaurantModel.class));
    }

    @Test
    void shouldListRestaurant(){
        //Arrange
        var id = UUID.randomUUID();
        var restaurant = helper.createRestaurant(id);


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
        var listOfRestaurant = Arrays.asList(helper.createRestaurant(UUID.randomUUID()),helper.createRestaurant(UUID.randomUUID()));
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
        var restaurant = helper.createRestaurant(UUID.randomUUID());
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
        var listOfRestaurant = Arrays.asList(helper.createRestaurant(UUID.randomUUID()),helper.createRestaurant(UUID.randomUUID()));
        when(restaurantRepository.findAllByAddress_City(any(String.class))).thenReturn(listOfRestaurant);

        //Act
        var listRestaurants = restaurantRepository.findAllByAddress_City("São Paulo");

        //
        assertThat(listRestaurants)
                .isNotNull()
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
        var listOfRestaurant = Arrays.asList(helper.createRestaurant(UUID.randomUUID()),helper.createRestaurant(UUID.randomUUID()));
        when(restaurantRepository.findAllByAddress(any(Address.class))).thenReturn(listOfRestaurant);

        //Act
        var listRestaurants = restaurantRepository.findAllByAddress(address);

        //
        assertThat(listRestaurants)
                .isNotNull()
                .hasSize(2);


        verify(restaurantRepository, times(1)).findAllByAddress(address);

    }

    @Test
    void shouldListAllRestaurantsOpeningHours(){
        OpeningHours openingHours = new OpeningHours(DayOfWeek.FRIDAY,LocalTime.now(), LocalTime.now());
        //Arrange
        var listOfRestaurant = Arrays.asList(helper.createRestaurant(UUID.randomUUID()),helper.createRestaurant(UUID.randomUUID()));
        when(restaurantRepository.findAllByOpeningHours(any(OpeningHours.class))).thenReturn(listOfRestaurant);

        //Act
        var listRestaurants = restaurantRepository.findAllByOpeningHours(openingHours);

        //
        assertThat(listRestaurants)
                .isNotNull()
                .hasSize(2);


        verify(restaurantRepository, times(1)).findAllByOpeningHours(openingHours);

    }

    @Test
    void shouldDeleteRestaurant(){
        var restaurant = helper.createRestaurant(UUID.randomUUID());


        doNothing().when(restaurantRepository).delete(any(RestaurantModel.class));

        restaurantRepository.delete(restaurant);

        verify(restaurantRepository, times(1)).delete(any(RestaurantModel.class));

    }


}
