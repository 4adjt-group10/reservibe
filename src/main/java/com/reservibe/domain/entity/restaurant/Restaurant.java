package com.reservibe.domain.entity.restaurant;

import com.reservibe.domain.enums.retaurant.Cuisine;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Restaurant {

    private UUID id;
    private String name;
    private Address address;
    private String phoneNumber;
    private String description;
    private Cuisine cuisine;
    private List<OpeningHours> openingHours;

    public Restaurant(UUID id,
                      String name,
                      Address address,
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

    public Restaurant(String name,
                      Address address,
                      String phoneNumber,
                      String description,
                      Cuisine cuisine,
                      List<OpeningHours> openingHours) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.description = description;
        this.cuisine = cuisine;
        this.openingHours = openingHours;
    }

    public Restaurant(String name,
                      Address address,
                      String phoneNumber,
                      String description,
                      Cuisine cuisine) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.description = description;
        this.cuisine = cuisine;
        this.openingHours = new ArrayList<>();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
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
