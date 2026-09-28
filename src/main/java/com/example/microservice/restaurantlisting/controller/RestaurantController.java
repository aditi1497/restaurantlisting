package com.example.microservice.restaurantlisting.controller;

import com.example.microservice.restaurantlisting.dto.RestaurantDto;
import com.example.microservice.restaurantlisting.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

    @Autowired
    RestaurantService restaurantService;

    @GetMapping("/fetcgAllRestaurants")
    public ResponseEntity<List<RestaurantDto>> fetchAllRestaurants()
    {
       List<RestaurantDto> list= restaurantService.findAllRestaurants();
       return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping("/addRestaurant")
    public ResponseEntity<RestaurantDto> saveRestaurant(@RequestBody  RestaurantDto restaurantDto)
    {
        RestaurantDto restaurantDto1= restaurantService.addRestaurantInDB(restaurantDto);
        return new ResponseEntity<>(restaurantDto1,HttpStatus.CREATED);
    }

    @GetMapping("fetchById/{id}")
    public ResponseEntity<RestaurantDto> findRestaurantById(@PathVariable Integer id)
    {
         return restaurantService.fetchRestaurantById(id);
    }
}
