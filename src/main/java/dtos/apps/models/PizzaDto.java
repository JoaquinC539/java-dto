package dtos.apps.models;

import java.util.List;

import lombok.Data;

@Data
public class PizzaDto {
    private Integer id;
    private String name;
    private Integer sauce;
    private List<Integer> toppings;

}
