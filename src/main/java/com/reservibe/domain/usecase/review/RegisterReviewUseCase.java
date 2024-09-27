package com.reservibe.domain.usecase.review;

import com.reservibe.domain.entity.review.Review;
import com.reservibe.domain.generic.output.OutputError;
import com.reservibe.domain.generic.output.OutputInterface;
import com.reservibe.domain.generic.output.OutputStatus;
import com.reservibe.domain.input.review.ReviewInput;
import com.reservibe.domain.output.register.RegisterOutput;
import com.reservibe.domain.output.review.ReviewOutput;
import com.reservibe.infra.adapter.review.CreateReviewAdapter;

public class RegisterReviewUseCase {
    private OutputInterface reviewOutput;

    private final CreateReviewAdapter createReviewAdapter;

    public RegisterReviewUseCase(CreateReviewAdapter createReviewAdapter) {
        this.createReviewAdapter = createReviewAdapter;
    }

    public void execute(ReviewInput reviewInput) {
       try{
           Review review = new Review(reviewInput.client(), reviewInput.reviewStars(), reviewInput.comment());
           createReviewAdapter.createReview(review);
           this.reviewOutput = new ReviewOutput(new OutputStatus(200, "ok", "ok"));

       }catch (Exception e){
           this.reviewOutput = new OutputError("Erro ao gerir a reserva verifique os dados",
                   new OutputStatus(404, "Not found", "Erro ao gerir a reserva verifique os dados"));
       }
    }

    public OutputInterface getReviewOutput() {
        return this.reviewOutput;
    }
}
