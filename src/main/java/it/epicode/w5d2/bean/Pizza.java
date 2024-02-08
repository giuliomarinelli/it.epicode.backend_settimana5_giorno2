package it.epicode.w5d2.bean;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Entity
public class Pizza extends MenuItem {
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "pizza_toppins_id",
            joinColumns = @JoinColumn(name = "pizza_id"),
            inverseJoinColumns = @JoinColumn(name = "topping_id")
    )
    private List<Topping> toppings = new ArrayList<>();

    @Override
    public String toString() {
        return super.getNome() + " ___ " + super.getCalorie() + "Kcal ___ " + toppings.stream()
            .map(Topping::getNome).collect(Collectors.joining(", ")) + " € ___ " + super.getPrezzo();
    }
}
