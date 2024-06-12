package dtos.apps.models;

import java.util.List;

// import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="pizzas")
@Data
public class Pizza {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="name")
    private String name;
    
    @ManyToOne
    @JoinColumn(name = "sauce",referencedColumnName = "id")
    private Sauce sauce;

    @ManyToMany
    @JoinTable(name = "pizza_topping",joinColumns = @JoinColumn(name="pizza_id"),inverseJoinColumns = @JoinColumn(name="topping_id"))
    private List<Topping> toppings;
}
