package com.example.microservice.restaurantlisting.mapper;

import com.example.microservice.restaurantlisting.dto.RestaurantDto;
import com.example.microservice.restaurantlisting.entity.Restaurant;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RestaurantMapper {

    RestaurantMapper  INSTANCE = Mappers.getMapper(RestaurantMapper.class);

    Restaurant mapRestaurantDTOToRestaurant(RestaurantDto restaurantDto);
    RestaurantDto mapRestaurantToRestaurantDTO(Restaurant restaurant);
}
