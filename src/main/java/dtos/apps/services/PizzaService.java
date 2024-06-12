package dtos.apps.services;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import dtos.apps.models.Pizza;
import dtos.apps.models.PizzaDto;
import dtos.apps.models.Sauce;
import dtos.apps.models.Topping;
import dtos.apps.repositories.PizzaJpa;
import dtos.apps.repositories.SauceJpa;
import dtos.apps.repositories.ToppingJpa;

@Service
public class PizzaService {
    private final PizzaJpa pizzaJpa;
    private final SauceJpa sauceJpa;
    private final ToppingJpa toppingJpa;
    public PizzaService(PizzaJpa repo,SauceJpa sauceJpa,ToppingJpa toppingJpa){
        this.pizzaJpa=repo;
        this.sauceJpa=sauceJpa;
        this.toppingJpa=toppingJpa;
    }
    public List<Pizza> index(){
        return pizzaJpa.findAll();
    }
    public Pizza post(PizzaDto pizzaDto){
        System.out.println(pizzaDto.getToppings().get(0));
        Optional<Sauce> sauce=sauceJpa.findById(pizzaDto.getSauce());
        List<Topping> toppings=new ArrayList<>();
        for(int i=0;i<pizzaDto.getToppings().size();i++){
            Optional<Topping> toppOptional=toppingJpa.findById(pizzaDto.getToppings().get(i));
            if(toppOptional.isPresent()){
                toppings.add(toppOptional.get());
            }
        }
                

        Pizza pizza = new Pizza();
        pizza.setName(pizzaDto.getName());
        pizza.setSauce(sauce.get());
        pizza.setToppings(toppings);
        return pizzaJpa.save(pizza);
        // return pizza;
    }

}
