//package com.reservibe.infra.repository.review;
//
//import com.reservibe.domain.enums.retaurant.Cuisine;
//import com.reservibe.domain.enums.review.ReviewStars;
//import com.reservibe.infra.model.restaurant.RestaurantModel;
//import com.reservibe.infra.model.review.ReviewModel;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Optional;
//import java.util.UUID;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.*;
//
//
//public class ReviewRepositoryTest {
//
//    @Mock
//    private ReviewRepository reviewRepository;
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
//    void shouldSaveReview(){
//        var review = createReview(UUID.randomUUID());
//
//        when(reviewRepository.save(any(ReviewModel.class))).thenReturn(review);
//        //Act
//        var reviewSaved = reviewRepository.save(review);
//        //validation
//        assertThat(reviewSaved)
//                .isNotNull()
//                .isEqualTo(review);
//
//        //verifica que o repository foi chamado ao menos 1 vez para salvar algo
//        verify(reviewRepository, times(1)).save(any(ReviewModel.class));
//
//    }
//
//    @Test
//    void shouldListReview(){
//        //Arrange
//        var id = UUID.randomUUID();
//        var review = createReview(id);
//
//        //Define comportamento quando for chamado esse método com o UUID
//        when(reviewRepository.findById(any(UUID.class))).thenReturn(Optional.of(review));
//
//        //Act
//        var reviewRead = reviewRepository.findById(id);
//
//        //Assert
//        assertThat(reviewRead)
//                .isPresent()
//                .containsSame(review);
//
//        reviewRead.ifPresent(rev ->{
//            assertThat(rev.getId()).isEqualTo(review.getId());
//            assertThat(rev.getClient().getName()).isEqualTo(review.getClient().getName());
//            assertThat(rev.getRestaurant().getName()).isEqualTo(review.getRestaurant().getName());
//            assertThat(rev.getReviewStars()).isEqualTo(review.getReviewStars());
//            assertThat(rev.getReviewDate()).isEqualTo(review.getReviewDate());
//            assertThat(rev.getComment()).isEqualTo(review.getComment());
//
//        });
//
//        verify(reviewRepository, times(1)).findById(any(UUID.class));
//
//    }
//
//    @Test
//    void shouldListAllReviews(){
//
//        var listOfReviews = Arrays.asList(createReview(UUID.randomUUID()),createReview(UUID.randomUUID()));
//        when(reviewRepository.findAll()).thenReturn(listOfReviews);
//
//        //Act
//        var listReviewsRead = reviewRepository.findAll();
//
//        //
//        assertThat(listReviewsRead)
//                .isNotNull()
//                .containsAll(listOfReviews)
//                .hasSize(2);
//
//
//        verify(reviewRepository, times(1)).findAll();
//    }
//
//    @Test
//    void shouldDeleteReview(){
//        var restaurant = createReview(UUID.randomUUID());
//
//        //Define comportamento quando for chamado esse método com o UUID
//        doNothing().when(reviewRepository).delete(any(ReviewModel.class));
//
//        reviewRepository.delete(restaurant);
//
//        verify(reviewRepository, times(1)).delete(any(ReviewModel.class));
//
//    }
//
//    private RestaurantModel createRestaurant(){
//        ArrayList lista = new ArrayList();
//        lista.add(13);
//        lista.add(14);
//        lista.add(15);
//
//        return RestaurantModel.builder()
//                .id(UUID.randomUUID())
//                .name("Restaurante")
//                .address("Avenida das luzes")
//                .phoneNumber("1187652435")
//                .description("Restaurante italiano")
//                .cuisine(Cuisine.ITALIAN)
//                .openingHours(lista)
//                .build();
//    }
//
//    private ClientModel createClient(){
//        return ClientModel.builder()
//                .id(UUID.randomUUID())
//                .name("Cliente")
//                .email("cliente@gmail.com")
//                .phone("1187652435")
//                .cpf("1234567890")
//                .build();
//    }
//
//    private ReviewModel createReview(UUID id){
//        return ReviewModel.builder()
//                .id(id)
//                .restaurant(createRestaurant())
//                .client(createClient())
//                .reviewStars(ReviewStars.FIVE)
//                .reviewDate(LocalDateTime.now())
//                .comment("Bom")
//                .build();
//    }
//}
