package it.epicode.w5d2.bean;

import lombok.Data;

@Data
public abstract class MenuItem {
    private String nome;
    private int calorie;
    private double prezzo;
}
