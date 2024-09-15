package com.reservibe.infra.adapter.reservation;

import com.reservibe.domain.entity.reservation.Reservation;
import com.reservibe.domain.entity.table.Table;
import com.reservibe.domain.gateway.reservation.SearchReservationInterface;
import com.reservibe.infra.model.table.TableModel;
import com.reservibe.infra.repository.reservation.ReservationRepository;

import java.util.List;
import java.util.UUID;

public class SearchReservationAdapter implements SearchReservationInterface {

    private final ReservationRepository reservationRepository;

    public SearchReservationAdapter(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Override
    public List<Reservation> findReservationByRestaurantId(UUID id) {
        return reservationRepository.listByRestaurantId(id)
        .stream().map(r -> {
            TableModel tableModel = r.getTable();
            return new Reservation(
                    r.getId(),
                    r.getClient(),
                    r.getStatus(),
                    r.getReservationDate(),
                    new Table(tableModel.getId(),
                            tableModel.getNumber(),
                            tableModel.getSeats(),
                            tableModel.getStatus()),
                    r.getNotesObservations()
            );
        }).toList();
    }
}
