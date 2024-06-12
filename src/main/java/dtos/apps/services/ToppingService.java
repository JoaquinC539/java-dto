package dtos.apps.services;

import org.springframework.stereotype.Service;

import dtos.apps.models.Topping;
import dtos.apps.models.ToppingDto;
import dtos.apps.repositories.ToppingJpa;

import java.util.List;
import java.util.Optional;


@Service
public class ToppingService {

    private final ToppingJpa toppingJpa;

    public ToppingService(ToppingJpa jpa){
        this.toppingJpa=jpa;
    }
    
    public List<Topping> index(){
        return toppingJpa.findAll();
    }
    public Topping post(ToppingDto toppingDto){
        Topping topping = new Topping();
        topping.setName(toppingDto.getName());
        return toppingJpa.save(topping);
    }
    public Topping get(int id){
        Optional<Topping> optTop=toppingJpa.findById(id);
        return optTop.get();
    }
}
