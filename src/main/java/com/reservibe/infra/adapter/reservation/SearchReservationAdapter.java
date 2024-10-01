package com.reservibe.infra.adapter.reservation;

import com.reservibe.domain.entity.client.Client;
import com.reservibe.domain.entity.reservation.Reservation;
import com.reservibe.domain.entity.restaurant.Restaurant;
import com.reservibe.domain.entity.table.Table;
import com.reservibe.domain.enums.reservation.ReservationStatus;
import com.reservibe.domain.gateway.reservation.SearchReservationInterface;
import com.reservibe.infra.model.restaurant.RestaurantModel;
import com.reservibe.infra.model.table.TableModel;
import com.reservibe.infra.repository.reservation.ReservationRepository;
import jakarta.persistence.EntityNotFoundException;

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
                                    tableModel.getSeats()),
                            r.getNotesObservations()
                    );
                }).toList();
    }

    @Override
    public List<Reservation> findReservationByClientAndStatus(Client client, ReservationStatus status) {
        return reservationRepository.listByClientAndStatus(client, status.name())
                .stream().map(r -> {
                    TableModel tableModel = r.getTable();
                    RestaurantModel restaurant = tableModel.getRestaurant();
                    return new Reservation(
                            r.getId(),
                            r.getClient(),
                            r.getStatus(),
                            r.getReservationDate(),
                            new Table(tableModel.getId(),
                                    tableModel.getNumber(),
                                    tableModel.getSeats(),
                                    tableModel.getStatus(),
                                    new Restaurant(restaurant.getId(),
                                            restaurant.getName(),
                                            restaurant.getAddress(),
                                            restaurant.getPhoneNumber(),
                                            restaurant.getDescription(),
                                            restaurant.getCuisine(),
                                            restaurant.getOpeningHours())),
                            r.getNotesObservations()
                    );
                }).toList();
    }

    @Override
    public Reservation findById(UUID id) {
        var reservation = reservationRepository.findById(id)
                .orElseThrow(()->new EntityNotFoundException("Table not Available"));
        var table = new Table(reservation.getTable().getId(),
                reservation.getTable().getNumber(),
                reservation.getTable().getSeats(),
                reservation.getTable().getStatus());

        return new Reservation(reservation.getId(),
                reservation.getClient(),
                reservation.getStatus(),
                reservation.getReservationDate(),
                table,
                reservation.getNotesObservations());
    }
}
