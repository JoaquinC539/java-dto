package dtos.apps.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import dtos.apps.models.Pizza;
import dtos.apps.models.PizzaDto;
import dtos.apps.services.PizzaService;

@RestController
@RequestMapping("/api/pizza")
public class PizzaController {
    private final PizzaService pizzaService;
    public PizzaController(PizzaService pizzaService){
        this.pizzaService=pizzaService;
    }
    @GetMapping()
    public List<Pizza> index(){
        return pizzaService.index();
    }
    @RequestMapping(method = RequestMethod.POST,name = "",consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE,MediaType.APPLICATION_JSON_VALUE})
    public Pizza post(@RequestBody PizzaDto pizzaDto){
       Pizza pizza=pizzaService.post(pizzaDto);
       return pizza; 
    }
}
