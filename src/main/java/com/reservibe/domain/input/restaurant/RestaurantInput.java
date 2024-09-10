package com.reservibe.domain.input.restaurant;

import com.reservibe.domain.entity.restaurant.Address;
import com.reservibe.domain.entity.restaurant.OpeningHours;
import com.reservibe.domain.enums.retaurant.Cuisine;
import com.reservibe.domain.input.table.TableInput;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

public record RestaurantInput(
        @NotBlank(message = "The restaurant name can't be null or empty") String name,
        @NotNull(message = "The restaurant address can't be null") Address address,
        @NotBlank(message = "The restaurant phone can't be null or empty")String phoneNumber,
        @NotBlank(message = "The restaurant description can't be null or empty")String description,
        @NotNull(message = "The restaurant cuisine can't be null") Cuisine cuisine,
        @NotNull(message = "The restaurant opening hours can't be null") List<OpeningHours> openingHours,
        @NotNull(message = "Tables can't be null") List<TableInput> tables
) {

    public RestaurantInput(String name, Address address, String phoneNumber, String description, Cuisine cuisine) {
        this(name, address, phoneNumber, description, cuisine, new ArrayList<>(), new ArrayList<>());
    }
}
