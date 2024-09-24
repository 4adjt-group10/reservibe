package com.reservibe.helper;

import com.reservibe.domain.entity.client.Client;
import com.reservibe.domain.entity.table.Table;
import com.reservibe.domain.input.reservation.CreateReservationInput;
import com.reservibe.domain.input.restaurant.RestaurantInput;
import com.reservibe.domain.input.table.TableInput;

import java.time.LocalDateTime;
import java.util.UUID;

public class ReservationHelper {

    public final CreateReservationInput createRestaurantInput(UUID tableId){
        var client = new Client(
                "nameClient",
                "nameClient@gmail.com",
                "1198762-1092",
                "52452452454"
        );
        return new CreateReservationInput(client,
                LocalDateTime.now(),
                tableId,
                "Reserva");
    }
}
