package com.reservibe.domain.input.restaurant;

import com.reservibe.domain.entity.restaurant.Address;
import com.reservibe.domain.enums.retaurant.Cuisine;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class RestaurantInputTest {

    @Test
    public void testRestaurantInputConstructor() {
        String name = "Test Restaurant";
        Address address = new Address("street",
                123,
                "neighborhood",
                "city",
                "state",
                "country",
                "zipCode"); // Supondo que você tenha um construtor padrão ou um mock para Address
        String phoneNumber = "123456789";
        String description = "A test restaurant";
        Cuisine cuisine = Cuisine.ITALIAN; // Supondo que você tenha um enum Cuisine com um valor ITALIAN

        RestaurantInput restaurantInput = new RestaurantInput(name, address, phoneNumber, description, cuisine);

        assertNotNull(restaurantInput);
        assertEquals(name, restaurantInput.name());
        assertEquals(address, restaurantInput.address());
        assertEquals(phoneNumber, restaurantInput.phoneNumber());
        assertEquals(description, restaurantInput.description());
        assertEquals(cuisine, restaurantInput.cuisine());
        assertNotNull(restaurantInput.openingHours());
        assertNotNull(restaurantInput.tables());
        assertEquals(0, restaurantInput.openingHours().size());
        assertEquals(0, restaurantInput.tables().size());
    }
}