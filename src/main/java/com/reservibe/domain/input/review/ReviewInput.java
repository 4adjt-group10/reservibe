package com.reservibe.domain.input.review;

import com.reservibe.domain.entity.client.Client;
import com.reservibe.domain.enums.review.ReviewStars;

public record ReviewInput(Client client, ReviewStars reviewStars, String comment) {
}
