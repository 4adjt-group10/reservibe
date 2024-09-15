package com.reservibe.infra.repository.reservation;

import com.reservibe.infra.model.reservation.ReservationModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface ReservationRepository extends JpaRepository<ReservationModel, UUID> {

    @Query(value = """
        SELECT r.* FROM reservation_model r
           JOIN table_model t ON r.table_id = t.id
           JOIN restaurant_model rm ON t.restaurant_id = rm.id
             WHERE rm.id = :id
        """, nativeQuery = true)
    List<ReservationModel> listByRestaurantId(UUID id);

}
