package com.reservibe.infra.adapter.review;

import com.reservibe.domain.entity.reservation.Reservation;
import com.reservibe.domain.entity.restaurant.Restaurant;
import com.reservibe.domain.entity.review.Review;
import com.reservibe.domain.enums.reservation.ReservationStatus;
import com.reservibe.domain.gateway.review.CreateReviewInterface;
import com.reservibe.infra.adapter.reservation.SearchReservationAdapter;
import com.reservibe.infra.model.restaurant.RestaurantModel;
import com.reservibe.infra.model.review.ReviewModel;
import com.reservibe.infra.repository.review.ReviewRepository;

import java.time.LocalDateTime;
import java.util.List;

public class CreateReviewAdapter implements CreateReviewInterface {

    private final ReviewRepository reviewRepository;
    private final SearchReservationAdapter searchReservationAdapter;

    public CreateReviewAdapter(ReviewRepository reviewRepository, SearchReservationAdapter searchReservationAdapter) {
        this.reviewRepository = reviewRepository;
        this.searchReservationAdapter = searchReservationAdapter;
    }

    @Override
    public Review createReview(Review review) {
        List<Reservation> reservationList = searchReservationAdapter
                .findReservationByClientAndStatus(review.getClient(), ReservationStatus.CONFIRMED);
        Restaurant restaurant = reservationList.get(0).getTable().getRestaurant();
        ReviewModel reviewModel = reviewRepository.save(new ReviewModel(new RestaurantModel(restaurant.getId(),
                restaurant.getName(),
                restaurant.getAddress(),
                restaurant.getPhoneNumber(),
                restaurant.getDescription(),
                restaurant.getCuisine(),
                restaurant.getOpeningHours()),
                review.getClient(),
                review.getReviewStars(),
                LocalDateTime.now(),
                review.getComment()));
        review.setId(reviewModel.getId());
        return review;
    }
}
