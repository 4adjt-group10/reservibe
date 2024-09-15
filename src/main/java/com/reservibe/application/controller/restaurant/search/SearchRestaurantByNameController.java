package com.reservibe.application.controller.restaurant.search;

import com.reservibe.application.response.GenericResponse;
import com.reservibe.application.response.PresenterResponse;
import com.reservibe.domain.output.restaurant.RestaurantOutput;
import com.reservibe.domain.presenters.restaurant.RestaurantPresenter;
import com.reservibe.domain.usecase.restaurant.search.SearchRestaurantByNameUseCase;
import com.reservibe.infra.adapter.restaurant.SearchRestaurantAdapter;
import com.reservibe.infra.repository.restaurant.RestaurantRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/restaurant/search/name")
public class SearchRestaurantByNameController {

    private final RestaurantRepository restaurantRepository;

    public SearchRestaurantByNameController(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }


    @GetMapping("/{name}")
    public ResponseEntity<Object> searchRestaurantByName(@PathVariable String name) {
        SearchRestaurantByNameUseCase searchRestaurantByNameUseCase = new SearchRestaurantByNameUseCase(new SearchRestaurantAdapter(restaurantRepository));
        RestaurantOutput output = searchRestaurantByNameUseCase.execute(name);
        if (output.getOutputStatus().getCode() != 200) {
            return new GenericResponse().response(output);
        }
        RestaurantPresenter restaurantPresenter = new RestaurantPresenter(output);
        return new PresenterResponse().response(restaurantPresenter);
    }
}
