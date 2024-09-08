package com.reservibe.domain.input.review;

import com.reservibe.domain.entity.restaurant.Restaurant;
import com.reservibe.domain.enums.review.ReviewStars;

import java.time.LocalDateTime;
import java.util.UUID;

public record CreateReviewInput(UUID clientId,
                                Restaurant restaurant,
                                ReviewStars reviewStars,
                                LocalDateTime reviewDate,
                                String comment) {
}
