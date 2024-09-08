package com.reservibe.infra.repository.table.review;

import com.reservibe.infra.model.review.ReviewModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface ReviewRepository extends JpaRepository<ReviewModel, UUID> {
}
