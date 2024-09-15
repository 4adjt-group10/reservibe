package com.reservibe.infra.repository.reservation;

import com.reservibe.infra.model.reservation.ReservationModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ReservationRepository extends JpaRepository<ReservationModel, UUID> {
}
