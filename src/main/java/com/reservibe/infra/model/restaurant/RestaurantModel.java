package com.reservibe.infra.model.restaurant;

import com.reservibe.domain.enums.retaurant.Cuisine;
import com.reservibe.domain.entity.restaurant.OpeningHours;
import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
public class RestaurantModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private String address;
    private String phoneNumber;
    private String description;
    private Cuisine cuisine;
    //TODO: Fix this
    @JoinTable(name = "restaurant_opening_hours",
                joinColumns = @JoinColumn(name = "restaurant_id"),
                inverseJoinColumns = @JoinColumn(name = "opening_hours_id"))
    private List<OpeningHours> openingHours;

    public RestaurantModel(UUID id,
                      String name,
                      String address,
                      String phoneNumber,
                      String description,
                      Cuisine cuisine,
                      List<OpeningHours> openingHours) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.description = description;
        this.cuisine = cuisine;
        this.openingHours = openingHours;
    }

    @Deprecated(since = "Only for framework use")
    public RestaurantModel() {

    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getDescription() {
        return description;
    }

    public Cuisine getCuisine() {
        return cuisine;
    }

    public List<OpeningHours> getOpeningHours() {
        return openingHours;
    }
}
