package com.reservibe.infra.model.review;

import com.reservibe.domain.entity.client.Client;
import com.reservibe.domain.enums.review.ReviewStars;
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
    private UUID id;
    @ManyToOne
    private RestaurantModel restaurant;
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb")
    private Client client;
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

