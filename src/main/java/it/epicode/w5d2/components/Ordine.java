package it.epicode.w5d2.components;

import it.epicode.w5d2.bean.MenuItem;
import it.epicode.w5d2.enums.StatoOrdine;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Component
public class Ordine {
    private int numero;
    private List<MenuItem> comanda = new ArrayList<>();
    @Autowired
    private Tavolo tavolo;
    private StatoOrdine stato;
    private int numCoperti;
    private LocalTime ora;
    private double costoTotale;
    private double costoCoperto;
    public void calcolaCostoTotale() {
        if (numCoperti > tavolo.getNumMaxCoperti()) {
            System.out.println("Errore, l'ordine ha un numero di coperti superiore al numero massimo previsto per il tavolo");
            return;
        }
        System.out.println(tavolo.getNumMaxCoperti());
        costoTotale = comanda.stream().mapToDouble(MenuItem::getPrezzo).sum() + costoCoperto * numCoperti;
    }
}
