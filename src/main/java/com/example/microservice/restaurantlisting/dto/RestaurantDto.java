package com.example.microservice.restaurantlisting.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data  // getter setter
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantDto {
    private int id;
    private String name;
    private String address;
    private String city;
    private String restaurantDescription;
}
