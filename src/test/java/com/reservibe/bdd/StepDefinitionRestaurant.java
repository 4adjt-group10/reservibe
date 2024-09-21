package com.reservibe.bdd;

import com.reservibe.domain.input.restaurant.RestaurantInput;
import com.reservibe.helper.RestaurantHelper;
import com.reservibe.infra.model.restaurant.RestaurantModel;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.springframework.http.MediaType;

import static io.restassured.RestAssured.given;

public class StepDefinitionRestaurant {

    private Response response;

    private RestaurantModel restaurantModel;

    private RestaurantHelper helper = new RestaurantHelper();

    private final String ENDPOINT_API_REGISTER = "http://localhost:8080/restaurant/register";


    @Given("I create a restaurant")
    public void i_create_a_restaurant() {
        var restaurantCreated = helper.createRestaurantInput();
        response = given()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(restaurantCreated)
                .when()
                .post(ENDPOINT_API_REGISTER);


    }

    @Then("the return must be {string}")
    public void the_return_must_be(String status) {
        System.out.println(response.statusCode());
        response.then().statusCode(Integer.parseInt(status));
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
//
//    @Given("that there is a saved restaurant")
//    public void that_there_is_a_saved_restaurant() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }
//    @When("I look for a restaurant by {string}")
//    public void i_look_for_a_restaurant_by(String string) {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }
//
//    @Given("that there are some saved restaurants")
//    public void that_there_are_some_saved_restaurants() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }
//    @When("I look for all restaurant")
//    public void i_look_for_all_restaurant() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }
//    @Then("all restaurants must be presented")
//    public void all_restaurants_must_be_presented() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }
//
//    @When("I update the restaurant")
//    public void i_update_the_restaurant() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }
//
//    @When("I delete a restaurant")
//    public void i_delete_a_restaurant() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }
//
//    //without tables
//    @When("I put {string}, {string}, {string}, {string}, {string}, {string}")
//    public void iPut(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5) {
//    }
//
//    @Then("the return must be {string} unsuccess")
//    public void theReturnMustBeUnsuccess(String arg0) {
//    }


}
