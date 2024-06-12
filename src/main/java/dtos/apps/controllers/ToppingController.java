package dtos.apps.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dtos.apps.models.Topping;
import dtos.apps.models.ToppingDto;
import dtos.apps.services.ToppingService;

@RestController
@RequestMapping( "/api/topping")
public class ToppingController {
    private final ToppingService toppingService;

    public ToppingController(ToppingService service){
        this.toppingService=service;
    }
    @GetMapping
    public ResponseEntity<List<Topping>> index(){
        return ResponseEntity.ok(toppingService.index());
    }
    

    @PostMapping
    public ResponseEntity<Topping> post(@RequestBody ToppingDto toppingDto){
        return ResponseEntity.ok().body(toppingService.post(toppingDto));
    }
    @GetMapping("{id}")
    public ResponseEntity<Topping> get(@PathVariable Integer id){
        return ResponseEntity.ok().body(toppingService.get(id));
    }
}
