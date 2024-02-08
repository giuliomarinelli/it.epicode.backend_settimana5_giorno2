package it.epicode.w5d2.bean;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Topping extends MenuItem {

    @ManyToMany(mappedBy = "toppings", fetch = FetchType.EAGER)
    private List<Pizza> pizze = new ArrayList<>();

    @Override
    public String toString() {
        return super.toString();
    }
}
