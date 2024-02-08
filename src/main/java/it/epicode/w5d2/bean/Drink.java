package it.epicode.w5d2.bean;

import jakarta.persistence.Entity;
import lombok.Data;

import java.util.stream.Collectors;

@Data
@Entity
public class Drink extends MenuItem {

    @Override
    public String toString() {
        return super.getNome() + " ___ " + super.getCalorie() + "Kcal ___ " + super.getPrezzo();
    }
}
