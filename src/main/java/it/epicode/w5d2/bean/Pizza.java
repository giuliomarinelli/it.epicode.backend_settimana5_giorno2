package it.epicode.w5d2.bean;

import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class Pizza extends MenuItem {
    private List<Topping> toppings = new ArrayList<>();

    @Override
    public String toString() {
        return super.getNome() + " ___ " + super.getCalorie() + "Kcal ___ " + toppings.stream()
            .map(Topping::getNome).collect(Collectors.joining(", ")) + "€" + super.getPrezzo();
    }
}
