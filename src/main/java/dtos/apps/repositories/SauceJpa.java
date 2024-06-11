package dtos.apps.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dtos.apps.models.Sauce;

public interface SauceJpa extends JpaRepository<Sauce,Integer>{

    
}
