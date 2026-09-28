package com.example.microservice.restaurantlisting.service;

import com.example.microservice.restaurantlisting.dto.RestaurantDto;
import com.example.microservice.restaurantlisting.entity.Restaurant;
import com.example.microservice.restaurantlisting.mapper.RestaurantMapper;
import com.example.microservice.restaurantlisting.repository.ResturantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RestaurantService {

    @Autowired
    ResturantRepo resturantRepo;


    public List<RestaurantDto> findAllRestaurants()
    {
     List<Restaurant> list=  resturantRepo.findAll();
        List<RestaurantDto> collect = list.stream().map(restaurant -> RestaurantMapper.INSTANCE.mapRestaurantToRestaurantDTO(restaurant)).collect(Collectors.toList());
        return collect;
    }

    public RestaurantDto addRestaurantInDB(RestaurantDto restaurantDto)
    {

       Restaurant saveRest= resturantRepo.save(RestaurantMapper.INSTANCE.mapRestaurantDTOToRestaurant(restaurantDto));
       return RestaurantMapper.INSTANCE.mapRestaurantToRestaurantDTO(saveRest);

    }

    public ResponseEntity<RestaurantDto> fetchRestaurantById(Integer id) {
        Optional<Restaurant> result = resturantRepo.findById(id);
        if (result.isPresent()) {
            return new ResponseEntity<>(RestaurantMapper.INSTANCE.mapRestaurantToRestaurantDTO(result.get()), HttpStatus.OK);
        }
        return new ResponseEntity<>(new RestaurantDto(),HttpStatus.NOT_FOUND);
    }

    // importatnt to save dto
}
