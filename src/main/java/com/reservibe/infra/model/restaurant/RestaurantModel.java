package com.reservibe.infra.model.restaurant;

import com.reservibe.domain.entity.restaurant.Address;
import com.reservibe.domain.entity.restaurant.OpeningHours;
import com.reservibe.domain.enums.retaurant.Cuisine;
import com.reservibe.infra.model.table.TableModel;
import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.List;
import java.util.UUID;

@Entity
public class RestaurantModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;
    @Column(unique = true)
    private String name;
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb")
    private Address address;
    private String phoneNumber;
    private String description;
    private Cuisine cuisine;
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb")
    private List<OpeningHours> openingHours;
    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TableModel> tables;

    public RestaurantModel(UUID id,
                           String name,
                           Address address,
                           String phoneNumber,
                           String description,
                           Cuisine cuisine,
                           List<OpeningHours> openingHours,
                           List<TableModel> tables) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.description = description;
        this.cuisine = cuisine;
        if(!openingHours.isEmpty()){
            this.openingHours = openingHours;
        }
        if(!tables.isEmpty()){
            this.tables = tables;
        }
    }

    public RestaurantModel(String name,
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
        if(!openingHours.isEmpty()){
            this.openingHours = openingHours;
        }
    }

    public RestaurantModel(UUID id,
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

    @Deprecated(since = "Only for framework use")
    public RestaurantModel() {

    }

    public UUID getId() {
        return id;
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

    public List<TableModel> getTables() {
        return tables;
    }
}
