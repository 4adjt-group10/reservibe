package com.reservibe.application.controller.review.request;

import com.reservibe.domain.entity.restaurant.Restaurant;
import com.reservibe.domain.enums.review.ReviewStars;

import java.time.LocalDateTime;

public record ReviewRequest(Restaurant restaurant,
                            ReviewStars reviewStars,
                            LocalDateTime reviewDate,
                            String comment) {
}
