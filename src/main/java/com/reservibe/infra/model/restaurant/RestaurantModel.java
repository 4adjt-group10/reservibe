package com.reservibe.infra.model.restaurant;

import com.reservibe.domain.enums.retaurant.Cuisine;
import com.reservibe.domain.entity.restaurant.OpeningHours;
import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.ArrayList;
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
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb")
    private List<OpeningHoursModel> openingHours;

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
        if(!openingHours.isEmpty()){
            openingHours.forEach(o -> {
                OpeningHoursModel openingHoursModel = new OpeningHoursModel(o);
                this.openingHours.add(openingHoursModel);
            });
        }
    }

    public RestaurantModel(String name,
                           String address,
                           String phoneNumber,
                           String description,
                           Cuisine cuisine,
                           List<OpeningHours> openingHours) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.description = description;
        this.cuisine = cuisine;
        if(!openingHours.isEmpty()){
            this.openingHours = new ArrayList<>();
            openingHours.forEach(o -> {
                OpeningHoursModel openingHoursModel = new OpeningHoursModel(o);
                this.openingHours.add(openingHoursModel);
            });
        }
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

    public List<OpeningHoursModel> getOpeningHours() {
        return openingHours;
    }

    public void setOpeningHours(List<OpeningHours> openingHours) {
        this.openingHours = new ArrayList<>();
        if(!openingHours.isEmpty()){
            openingHours.forEach(o -> {
                OpeningHoursModel openingHoursModel = new OpeningHoursModel(o);
                this.openingHours.add(openingHoursModel);
            });
        }
    }
}
