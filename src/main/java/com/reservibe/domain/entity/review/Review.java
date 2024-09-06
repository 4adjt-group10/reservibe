package com.reservibe.domain.entity.review;

import com.reservibe.domain.entity.client.Client;
import com.reservibe.domain.entity.restaurant.Restaurant;
import com.reservibe.domain.enums.review.ReviewStars;

import java.time.LocalDateTime;
import java.util.UUID;

public class Review {
    private UUID id;
    private Restaurant restaurant;
    private Client client;
    private ReviewStars reviewStars;
    private LocalDateTime reviewDate;
    private String comment;

    public Review(UUID id, Restaurant restaurant, Client client, ReviewStars reviewStars, LocalDateTime reviewDate, String comment) {
        this.id = id;
        this.restaurant = restaurant;
        this.client = client;
        this.reviewStars = reviewStars;
        this.reviewDate = reviewDate;
        this.comment = comment;
    }

    @Deprecated(since = "Only for framework use")
    public Review() {}

    public UUID getId() {
        return id;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public Client getClient() {
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
