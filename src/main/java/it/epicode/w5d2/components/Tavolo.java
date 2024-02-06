package it.epicode.w5d2.components;

import it.epicode.w5d2.enums.StatoTavolo;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Tavolo {
    private int numero;
    private int numMaxCoperti;
    private StatoTavolo stato;
}
