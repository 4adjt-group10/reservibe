package com.reservibe.application.controller.restaurant.search;

import com.reservibe.application.response.GenericResponse;
import com.reservibe.application.response.PresenterResponse;
import com.reservibe.domain.enums.retaurant.Cuisine;
import com.reservibe.domain.output.restaurant.RestaurantListOutput;
import com.reservibe.domain.presenters.restaurant.RestaurantListPresenter;
import com.reservibe.domain.usecase.restaurant.search.SearchRestaurantByCuisineUseCase;
import com.reservibe.infra.adapter.restaurant.SearchRestaurantAdapter;
import com.reservibe.infra.repository.restaurant.RestaurantRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/restaurant/search/cuisine")
public class SearchRestaurantByCuisineController {

    private final RestaurantRepository restaurantRepository;

    public SearchRestaurantByCuisineController(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @GetMapping("/{cuisine}")
    public ResponseEntity<Object> searchRestaurantByName(@PathVariable Cuisine cuisine) {
        SearchRestaurantByCuisineUseCase searchRestaurantByCuisineUseCase = new SearchRestaurantByCuisineUseCase(new SearchRestaurantAdapter(restaurantRepository));
        RestaurantListOutput listOutput = searchRestaurantByCuisineUseCase.execute(cuisine);
        if (listOutput.getOutputStatus().getCode() != 200) {
            return new GenericResponse().response(listOutput);
        }
        RestaurantListPresenter restaurantPresenter = new RestaurantListPresenter(listOutput);
        return new PresenterResponse().response(restaurantPresenter);
    }
}
