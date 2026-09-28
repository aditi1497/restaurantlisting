package com.example.microservice.restaurantlisting.repository;

import com.example.microservice.restaurantlisting.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResturantRepo extends JpaRepository<Restaurant,Integer> {
}
