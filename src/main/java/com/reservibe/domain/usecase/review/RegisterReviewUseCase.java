package com.reservibe.domain.usecase.review;

import com.reservibe.domain.entity.review.Review;
import com.reservibe.domain.input.review.ReviewInput;
import com.reservibe.infra.adapter.review.CreateReviewAdapter;

public class RegisterReviewUseCase {

    private final CreateReviewAdapter createReviewAdapter;

    public RegisterReviewUseCase(CreateReviewAdapter createReviewAdapter) {
        this.createReviewAdapter = createReviewAdapter;
    }

    public void execute(ReviewInput reviewInput) {
       Review review = new Review(reviewInput.client(), reviewInput.reviewStars(), reviewInput.comment());
        createReviewAdapter.createReview(review);
    }
}
