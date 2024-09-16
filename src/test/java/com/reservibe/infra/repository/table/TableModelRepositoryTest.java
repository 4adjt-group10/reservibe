//package com.reservibe.infra.repository.table;
//
//
//import com.reservibe.domain.entity.restaurant.Address;
//import com.reservibe.domain.enums.retaurant.Cuisine;
//import com.reservibe.domain.enums.table.TableStatus;
//import com.reservibe.infra.model.restaurant.RestaurantModel;
//import com.reservibe.infra.model.table.TableModel;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.testcontainers.shaded.org.bouncycastle.crypto.paddings.TBCPadding;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.UUID;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.junit.Assert.fail;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.*;
//
//public class TableModelRepositoryTest {
//
//    @Mock
//    private TableModelRepository tableModelRepository;
//
//    AutoCloseable openMocks;
//
//    @BeforeEach
//    void setup(){
//        openMocks = MockitoAnnotations.openMocks(this);
//    }
//
//    @AfterEach
//    void tearDown() throws Exception {
//        openMocks.close();
//    }
//
//    @Test
//    void shouldSaveTable(){
//        var table = createTable();
//
//        when(tableModelRepository.save(any(TableModel.class))).thenReturn(table);
//        //Act
//        var tableSaved = tableModelRepository.save(table);
//        //validation
//        assertThat(tableSaved)
//                .isNotNull()
//                .isEqualTo(table);
//
//        //verifica que o repository foi chamado ao menos 1 vez para salvar algo
//        verify(tableModelRepository, times(1)).save(any(TableModel.class));
//
//    }
////
////    @Test
////    void shouldListTable(){
////        fail("Método não implementado");
////    }
////
////    @Test
////    void shouldListAllTables(){
////        fail("Método não implementado");
////    }
////
////    @Test
////    void shouldUpdateTable(){
////        fail("Método não implementado");
////    }
////
////    @Test
////    void shouldDeleteTable(){
////        fail("Método não implementado");
////    }
//
//    private RestaurantModel createRestaurant(UUID id){
//        ArrayList lista = new ArrayList();
//        lista.add(13);
//        lista.add(14);
//        lista.add(15);
//
//        return RestaurantModel.builder()
//                .id(id)
//                .name("Restaurante")
//                .address(new Address("street",
//                        123,
//                        "neighborhood",
//                        "city",
//                        "state",
//                        "country",
//                        "zipCode"))
//                .phoneNumber("1187652435")
//                .description("Restaurante italiano")
//                .cuisine(Cuisine.ITALIAN)
//                .openingHours(lista)
//                .tables(List.of(createTable()))
//                .build();
//    }
//
//    private TableModel createTable(){
//        return new TableModel(1,4, TableStatus.FREE);
//    }
//}
