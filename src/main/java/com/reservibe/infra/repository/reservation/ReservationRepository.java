package com.reservibe.infra.repository.reservation;

import com.reservibe.domain.entity.client.Client;
import com.reservibe.infra.model.reservation.ReservationModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface ReservationRepository extends JpaRepository<ReservationModel, UUID> {

    @Query(value = """
        SELECT r.* FROM reservation_model r
           JOIN table_model t ON r.table_id = t.id
           JOIN restaurant_model rm ON t.restaurant_id = rm.id
             WHERE rm.id = :id
    """, nativeQuery = true)
    List<ReservationModel> listByRestaurantId(@Param("id") UUID id);

    @Query(value = """
       SELECT r.* FROM reservation_model r
        WHERE r.client @> cast(:client as jsonb)
        AND r.status = :status
    """, nativeQuery = true)
    List<ReservationModel> listByClientAndStatus(@Param("client") Client client, @Param("status") String status);
}
