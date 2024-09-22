package com.reservibe.bdd;

import com.reservibe.domain.input.restaurant.RestaurantInput;
import com.reservibe.helper.RestaurantHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.springframework.http.MediaType;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class StepDefinitionRestaurant {

    private Response response;

    private RestaurantHelper helper = new RestaurantHelper();

    private RestaurantInput restaurantValid;

    private final String ENDPOINT_API_REGISTER = "http://localhost:8080/restaurant/register";
    private final String ENDPOINT_API_FIND_BYCITY = "http://localhost:8080/restaurant/search/city/{city}";
    private final String ENDPOINT_API_FIND_BYADDRESS = "http://localhost:8080/restaurant/search/address";
    private final String ENDPOINT_API_FIND_BYNAME = "/restaurant/search/name/{name}";
    private final String ENDPOINT_API_FIND_BYCUISINE = "/restaurant/search/cuisine/{cuisine}";

    @Given("I create a restaurant with {string} and {string} and {string}")
    public void i_create_a_restaurant_with_and_and(String name, String city, String cuisine) {
        var restaurantCreated = helper.createRestaurantInputWithData(name, city, cuisine);
        restaurantValid = restaurantCreated;
        response = given()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(restaurantCreated)
                .when()
                .post(ENDPOINT_API_REGISTER);

        System.out.println(response.statusCode());
    }


    @Then("the return must be {string}")
    public void the_return_must_be(String status) {
        response.then().statusCode(Integer.parseInt(status))
                .log().all();
    }

    @Given("I create a restaurant without tables")
    public void iCreateARestaurantWithoutTables() {
        var restaurantCreated = helper.createRestaurantInputWithOutTable();
        response = given()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(restaurantCreated)
                .when()
                .post(ENDPOINT_API_REGISTER);

    }

    @Given("that there is a saved restaurant")
    public void that_there_is_a_saved_restaurant() {
        var restaurantCreated = helper.createRestaurantInput();
        restaurantValid = restaurantCreated;
        response = given()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(restaurantCreated)
                .when()
                .post(ENDPOINT_API_REGISTER);
        System.out.println(response.statusCode());
    }

    @When("I look for a restaurant by city")
    public void i_look_for_a_restaurant_by_city() {
        response = when().get(ENDPOINT_API_FIND_BYCITY, restaurantValid.address().getCity());
    }

    @When("I look for a restaurant by address")
    public void iLookForARestaurantByAddress() {
        response = given()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(restaurantValid.address())
                .when()
                .post(ENDPOINT_API_FIND_BYADDRESS);

    }

    @When("I look for a restaurant by cuisine")
    public void iLookForARestaurantByCuisine() {
        response = when().get(ENDPOINT_API_FIND_BYCUISINE, restaurantValid.cuisine());
    }

    @When("I look for a restaurant by name")
    public void iLookForARestaurantByName() {
        response = when().get(ENDPOINT_API_FIND_BYNAME, restaurantValid.name());
    }


    @And("the restaurants city should be like {string}")
    public void theRestaurantsCityShouldBeLike(String data) {
        //then()
    }
}
