package com.reservibe.domain.usecase.restaurant.register;

import com.reservibe.domain.entity.restaurant.Restaurant;
import com.reservibe.domain.entity.table.Table;
import com.reservibe.domain.generic.output.OutputError;
import com.reservibe.domain.generic.output.OutputInterface;
import com.reservibe.domain.generic.output.OutputStatus;
import com.reservibe.domain.input.restaurant.RestaurantInput;
import com.reservibe.domain.output.register.RegisterOutput;
import com.reservibe.infra.adapter.restaurant.RegisterRestaurantAdapter;

public class RegisterRestaurantUseCase {
    private OutputInterface registerOutput;
    private final RegisterRestaurantAdapter registerRestaurantAdapter;

    public RegisterRestaurantUseCase(RegisterRestaurantAdapter registerRestaurantAdapter) {
        this.registerRestaurantAdapter = registerRestaurantAdapter;
    }

    public void execute(RestaurantInput restaurantInput) {
        try{
            Restaurant restaurant = new Restaurant(restaurantInput.name(),
                    restaurantInput.address(),
                    restaurantInput.phoneNumber(),
                    restaurantInput.description(),
                    restaurantInput.cuisine(),
                    restaurantInput.openingHours(), restaurantInput.tables().stream()
                    .map(t -> new Table(t.number(), t.seats(), t.status())).toList());
            registerRestaurantAdapter.registerRestaurant(restaurant);
            this.registerOutput = new RegisterOutput(new OutputStatus(200, "ok", "ok"));

        }catch (Exception e){
            this.registerOutput = new OutputError("Erro ao gerir a reserva verifique os dados",
                    new OutputStatus(404, "Not found", "Erro ao gerir a reserva verifique os dados"));
        }
    }

    public OutputInterface getRegisterOutput() {
        return this.registerOutput;
    }
}
