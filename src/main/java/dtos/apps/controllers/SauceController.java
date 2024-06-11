package dtos.apps.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import dtos.apps.services.SauceService;

import dtos.apps.models.Sauce;
import dtos.apps.models.SauceDto;


import java.util.List;


@RestController
@RequestMapping("/api/sauce")
public class SauceController {
    public final SauceService sauceService;
    public SauceController(SauceService service){
        this.sauceService=service;
    }
    
    @GetMapping
    public List<Sauce> index(){
       return sauceService.index();
    }
   
    // @PostMapping() ç
    @RequestMapping(method = RequestMethod.POST,name = "",consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE,MediaType.APPLICATION_JSON_VALUE})
    public Sauce post(@RequestBody SauceDto sauceDto){                     
        Sauce sauce=sauceService.post(sauceDto);
        return sauce;
    }
    @GetMapping("/{id}")
    public Sauce get(@PathVariable int id){
        Sauce sauce=sauceService.get(id);
        return sauce;
    }
    
    @PutMapping("/{id}")
    public Sauce update(@PathVariable int id, @RequestBody SauceDto sauceDto){
        return sauceService.update(id, sauceDto);
    }
}
