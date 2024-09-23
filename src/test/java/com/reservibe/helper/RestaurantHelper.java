package com.reservibe.helper;

import com.reservibe.domain.entity.restaurant.Address;
import com.reservibe.domain.entity.restaurant.OpeningHours;
import com.reservibe.domain.enums.retaurant.Cuisine;
import com.reservibe.domain.input.restaurant.RestaurantInput;
import com.reservibe.domain.input.table.TableInput;
import com.reservibe.infra.model.restaurant.RestaurantModel;
import com.reservibe.infra.model.table.TableModel;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class RestaurantHelper {

    TableHelper helper = new TableHelper();

    public final RestaurantModel createRestaurant(UUID id){
        List<OpeningHours> openingHours = new ArrayList<>();
        OpeningHours openingHours1 = new OpeningHours(DayOfWeek.MONDAY, LocalTime.now(),LocalTime.now());
        OpeningHours openingHours2 = new OpeningHours(DayOfWeek.FRIDAY, LocalTime.now(),LocalTime.now());
        OpeningHours openingHours3 = new OpeningHours(DayOfWeek.SATURDAY, LocalTime.now(),LocalTime.now());
        openingHours.add(openingHours2);
        openingHours.add(openingHours3);
        openingHours.add(openingHours1);
        List<TableModel> tableModels = new ArrayList<>();
        tableModels.add(helper.createTableModelWithoutId());
        var addres = new Address("street",
                123,
                "neighborhood",
                "São Paulo",
                "state",
                "country",
                "zipCode");

        return new RestaurantModel(id,
                "Restaurante",
                addres,
                "1187652435",
                "Restaurante italiano",
                Cuisine.ITALIAN,
                openingHours,tableModels);
    }

    public final RestaurantInput createRestaurantInput(){
        List<OpeningHours> openingHours = new ArrayList<>();
        OpeningHours openingHours1 = new OpeningHours(DayOfWeek.MONDAY, LocalTime.now(),LocalTime.now());
        OpeningHours openingHours2 = new OpeningHours(DayOfWeek.FRIDAY, LocalTime.now(),LocalTime.now());
        OpeningHours openingHours3 = new OpeningHours(DayOfWeek.SATURDAY, LocalTime.now(),LocalTime.now());
        openingHours.add(openingHours2);
        openingHours.add(openingHours3);
        openingHours.add(openingHours1);
        List<TableInput> tableInputs = new ArrayList<>();
        tableInputs.add(helper.createTableInput());
        var addres = new Address("street",
                123,
                "neighborhood",
                "São Paulo",
                "state",
                "country",
                "zipCode");

        return new RestaurantInput(
                "Restaurante",
                addres,
                "1187652435",
                "Restaurante italiano",
                Cuisine.ITALIAN,
                openingHours,tableInputs);
    }
    public final RestaurantInput createRestaurantInputWithOutTable(){
        List<OpeningHours> openingHours = new ArrayList<>();
        OpeningHours openingHours1 = new OpeningHours(DayOfWeek.MONDAY, LocalTime.now(),LocalTime.now());
        OpeningHours openingHours2 = new OpeningHours(DayOfWeek.FRIDAY, LocalTime.now(),LocalTime.now());
        OpeningHours openingHours3 = new OpeningHours(DayOfWeek.SATURDAY, LocalTime.now(),LocalTime.now());
        openingHours.add(openingHours2);
        openingHours.add(openingHours3);
        openingHours.add(openingHours1);
        List<TableInput> tableInputs = new ArrayList<>();
        tableInputs.add(helper.createTableInput());
        var addres = new Address("street",
                123,
                "neighborhood",
                "São Paulo",
                "state",
                "country",
                "zipCode");

        return new RestaurantInput(
                "Restaurante",
                addres,
                "1187652435",
                "Restaurante italiano",
                Cuisine.ITALIAN,
                openingHours,null);
    }

    public final RestaurantInput createRestaurantInputWithData(String name, String city, String cuisine){
        List<OpeningHours> openingHours = new ArrayList<>();
        OpeningHours openingHours1 = new OpeningHours(DayOfWeek.MONDAY, LocalTime.now(),LocalTime.now());
        OpeningHours openingHours2 = new OpeningHours(DayOfWeek.FRIDAY, LocalTime.now(),LocalTime.now());
        OpeningHours openingHours3 = new OpeningHours(DayOfWeek.SATURDAY, LocalTime.now(),LocalTime.now());
        openingHours.add(openingHours2);
        openingHours.add(openingHours3);
        openingHours.add(openingHours1);
        List<TableInput> tableInputs = new ArrayList<>();
        tableInputs.add(helper.createTableInput());
        var addres = new Address("street",
                123,
                "neighborhood",
                city,
                "state",
                "country",
                "zipCode");

        return new RestaurantInput(
                name,
                addres,
                "1187652435",
                "Restaurante italiano",
                Cuisine.valueOf(cuisine),
                openingHours,tableInputs);
    }

    public final RestaurantInput createRestaurantInputWithStatus(String name, String city, String cuisine, String status1, String status2){
        List<OpeningHours> openingHours = new ArrayList<>();
        OpeningHours openingHours1 = new OpeningHours(DayOfWeek.MONDAY, LocalTime.now(),LocalTime.now());
        OpeningHours openingHours2 = new OpeningHours(DayOfWeek.FRIDAY, LocalTime.now(),LocalTime.now());
        OpeningHours openingHours3 = new OpeningHours(DayOfWeek.SATURDAY, LocalTime.now(),LocalTime.now());
        openingHours.add(openingHours2);
        openingHours.add(openingHours3);
        openingHours.add(openingHours1);
        List<TableInput> tableInputs = helper.createTableInputWithStatus(status1,status2);
        var addres = new Address("street",
                123,
                "neighborhood",
                city,
                "state",
                "country",
                "zipCode");

        return new RestaurantInput(
                name,
                addres,
                "1187652435",
                "Restaurante italiano",
                Cuisine.valueOf(cuisine),
                openingHours,tableInputs);
    }
}
