package com.reservibe.infra.repository.restaurant;

import com.reservibe.domain.entity.restaurant.Address;
import com.reservibe.domain.enums.retaurant.Cuisine;
import com.reservibe.domain.enums.table.TableStatus;
import com.reservibe.infra.model.restaurant.RestaurantModel;
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
                .containsAll(listRestaurants)
                .hasSize(2);


        verify(restaurantRepository, times(1)).findAllByCuisine(Cuisine.ITALIAN);

    }

//    @Test
//    void shouldListAllRestaurantsOpeningHours(){
//        fail("Método não implementado");
//    }
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
        ArrayList lista = new ArrayList();
        lista.add(13);
        lista.add(14);
        lista.add(15);

        return RestaurantModel.builder()
                .id(id)
                .name("Restaurante")
                .address(new Address("street",
        123,
        "neighborhood",
        "city",
        "state",
        "country",
        "zipCode"))
                .phoneNumber("1187652435")
                .description("Restaurante italiano")
                .cuisine(Cuisine.ITALIAN)
                .openingHours(lista)
                .tables(List.of(createTable()))
                .build();
    }

    private TableModel createTable(){
        return new TableModel(1,4, TableStatus.FREE);
    }
}
