package com.reservibe.infra.model.review;

import com.reservibe.domain.enums.review.ReviewStars;
import com.reservibe.infra.model.client.ClientModel;
import com.reservibe.infra.model.restaurant.RestaurantModel;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;
@Entity
public class ReviewModel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @ManyToOne
    private RestaurantModel restaurant;
    @ManyToOne
    private ClientModel client;
    @Enumerated(EnumType.STRING)
    private ReviewStars reviewStars;
    private LocalDateTime reviewDate;
    private String comment;

    public ReviewModel() {}

    public ReviewModel(UUID id, RestaurantModel restaurant, ClientModel client, ReviewStars reviewStars, LocalDateTime reviewDate, String comment) {
        this.id = id;
        this.restaurant = restaurant;
        this.client = client;
        this.reviewStars = reviewStars;
        this.reviewDate = reviewDate;
        this.comment = comment;
    }

    public UUID getId() {
        return id;
    }

    public RestaurantModel getRestaurant() {
        return restaurant;
    }

    public ClientModel getClient() {
        return client;
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
}

