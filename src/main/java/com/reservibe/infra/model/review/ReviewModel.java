package com.reservibe.infra.model.review;

import com.reservibe.domain.entity.client.Client;
import com.reservibe.domain.enums.review.ReviewStars;
import com.reservibe.infra.model.reservation.ReservationModel;
import com.reservibe.infra.model.restaurant.RestaurantModel;
import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.UUID;
@Entity
public class ReviewModel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;
    @ManyToOne
    private RestaurantModel restaurant;
    @JdbcTypeCode(SqlTypes.JSON)
    @ManyToOne
    private ReservationModel reservation;
    @Enumerated(EnumType.STRING)
    private ReviewStars reviewStars;
    private LocalDateTime reviewDate;
    private String comment;

    public ReviewModel() {}

    public ReviewModel(UUID id,
                       RestaurantModel restaurant,
                       Client client,
                       ReviewStars reviewStars,
                       LocalDateTime reviewDate,
                       String comment) {
        this.id = id;
        this.restaurant = restaurant;
        this.reviewStars = reviewStars;
        this.reviewDate = reviewDate;
        this.comment = comment;
    }

    public ReviewModel(RestaurantModel restaurant,
                       ReviewStars reviewStars,
                       LocalDateTime reviewDate,
                       String comment,
                       ReservationModel reservation) {
        this.restaurant = restaurant;
        this.reviewStars = reviewStars;
        this.reviewDate = reviewDate;
        this.comment = comment;
        this.reservation = reservation;
    }

    public UUID getId() {
        return id;
    }

    public RestaurantModel getRestaurant() {
        return restaurant;
    }

    public ReviewStars getReviewStars() {
        return reviewStars;
    }

    public LocalDateTime getReviewDate() {
        return reviewDate;
    }

    public String getComment() {
        return comment;
    }

    public ReservationModel getReservation() {
        return reservation;
    }
}

