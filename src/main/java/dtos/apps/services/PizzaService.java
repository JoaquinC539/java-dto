package dtos.apps.services;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import dtos.apps.models.Pizza;
import dtos.apps.models.PizzaDto;
import dtos.apps.models.Sauce;
import dtos.apps.repositories.PizzaJpa;
import dtos.apps.repositories.SauceJpa;

@Service
public class PizzaService {
    private final PizzaJpa pizzaJpa;
    private final SauceJpa sauceJpa;
    public PizzaService(PizzaJpa repo,SauceJpa sauceJpa){
        this.pizzaJpa=repo;
        this.sauceJpa=sauceJpa;
    }
    public List<Pizza> index(){
        return pizzaJpa.findAll();
    }
    public Pizza post(PizzaDto pizzaDto){
        // Sauce sauce = sauceJpa.findById(pizzaDto.getSauce());
        Optional<Sauce> sauce=sauceJpa.findById(pizzaDto.getSauce());
                

        Pizza pizza = new Pizza();
        pizza.setName(pizzaDto.getName());
        pizza.setSauce(sauce.get());
        return pizzaJpa.save(pizza);
        // return pizza;
    }

}
