package it.epicode.w5d2.services;

import it.epicode.w5d2.bean.MenuItem;
import it.epicode.w5d2.bean.Pizza;
import it.epicode.w5d2.bean.Topping;
import it.epicode.w5d2.repositories.MIRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MIService {
    @Autowired
    private MIRepository miRepo;
    public void save(MenuItem m) {
        miRepo.save(m);
    }

    public MenuItem findById(UUID id) {
        Optional<MenuItem> opt = miRepo.findById(id);
        return opt.orElse(null);
    }

    public void delete(UUID id) {
        miRepo.deleteById(id);
    }

    public MenuItem findById(String id) {
        return findById(UUID.fromString(id));
    }

    public void delete(String id) {
        delete(UUID.fromString(id));
    }

    public int countToppingsByPizza(Pizza p) {
        return p.getToppings().size();
    }

    public void saveMany(MenuItem... m) { // (pizza1, pizza2 ecc
        for (MenuItem mi: m) {
            save(mi);
        }
    }

    public void addToppingsToPizza(Pizza p, Topping... t) {
        for (Topping to : t) {
            p.getToppings().add(to);
        }
    }

    public List<MenuItem> searchByName(String nome) {
        return miRepo.findByNomeContainingIgnoreCase(nome);
    }

    public long countToppings() {
        return miRepo.quantiToppingsCiSono();
    }
}
