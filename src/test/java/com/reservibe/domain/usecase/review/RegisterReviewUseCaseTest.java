package com.reservibe.domain.usecase.review;

import com.reservibe.domain.entity.client.Client;
import com.reservibe.domain.entity.review.Review;
import com.reservibe.domain.enums.review.ReviewStars;
import com.reservibe.domain.input.review.ReviewInput;
import com.reservibe.infra.adapter.review.CreateReviewAdapter;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class RegisterReviewUseCaseTest {

    @Mock
            private CreateReviewAdapter createReviewAdapter;

    @InjectMocks
            private RegisterReviewUseCase registerReviewUseCase;

    AutoCloseable openMocks;
    @BeforeEach
    void setup(){
        openMocks = MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    void tearDown() throws Exception {
        openMocks.close();
    }

    @Test
    void execute() {
        when(createReviewAdapter.createReview(any(Review.class))).thenReturn(createReview());
        registerReviewUseCase.execute(createReviewInput());
        verify(createReviewAdapter).createReview(any(Review.class));
    }

    public final ReviewInput createReviewInput(){
        var client = new Client("name_teste", "email@test.com", "9998845436", "11234543210");
        return new ReviewInput(client, ReviewStars.FIVE, "comment");

    }

    public final Review createReview() {
        var client = new Client("name_teste", "email@test.com", "9998845436", "11234543210");
        return new Review(client, ReviewStars.FIVE, "comment");
    }
}