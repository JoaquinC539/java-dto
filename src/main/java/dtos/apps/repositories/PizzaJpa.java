package dtos.apps.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dtos.apps.models.Pizza;

public interface PizzaJpa extends JpaRepository<Pizza,Integer>{
    
}
