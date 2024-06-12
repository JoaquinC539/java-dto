package dtos.apps.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dtos.apps.models.Topping;

public interface ToppingJpa extends JpaRepository<Topping,Integer>{
    
}
