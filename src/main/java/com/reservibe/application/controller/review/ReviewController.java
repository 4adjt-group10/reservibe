package com.reservibe.application.controller.review;

import com.reservibe.application.controller.review.request.ReviewRequest;
import com.reservibe.domain.gateway.review.CreateReviewInterface;
import com.reservibe.domain.input.review.CreateReviewInput;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/review")
public class ReviewController {


    @PostMapping("/create/{clientId}")
    public void createReview(@PathVariable UUID clientId, @RequestBody ReviewRequest review) {
        CreateReviewInput reviewInput = new CreateReviewInput(clientId,
                review.restaurant(),
                review.reviewStars(),
                review.reviewDate(),
                review.comment()
        );

    }
}
