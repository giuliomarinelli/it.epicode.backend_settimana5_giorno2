package it.epicode.w5d2;

import it.epicode.w5d2.bean.Drink;
import it.epicode.w5d2.bean.Pizza;
import it.epicode.w5d2.bean.Topping;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.List;

@Configuration
@PropertySource("application.properties")
public class AppConfig {

    public static final double prezzoBase = 6;

    @Bean("cheese")
    public Topping cheese() {
        Topping c = new Topping();
        c.setNome("cheese");
        c.setCalorie(300);
        c.setPrezzo(1);
        return c;
    }

    @Bean("tomato")
    public Topping tomato() {
        Topping c = new Topping();
        c.setNome("tomato");
        c.setCalorie(150);
        c.setPrezzo(0.5);
        return c;
    }

    @Bean("onions")
    public Topping onions() {
        Topping c = new Topping();
        c.setNome("onions");
        c.setCalorie(50);
        c.setPrezzo(1.5);
        return c;
    }

    @Bean("ham")
    public Topping ham() {
        Topping c = new Topping();
        c.setNome("ham");
        c.setCalorie(350);
        c.setPrezzo(2.5);
        return c;
    }

    @Bean("salami")
    public Topping salami() {
        Topping c = new Topping();
        c.setNome("salami");
        c.setCalorie(400);
        c.setPrezzo(3);
        return c;
    }

    @Bean("lemonade")
    public Drink lemonade() {
        Drink c = new Drink();
        c.setNome("lemonade (0.33l)");
        c.setCalorie(100);
        c.setPrezzo(3);
        return c;
    }

    @Bean("water")
    public Drink water() {
        Drink c = new Drink();
        c.setNome("water (0.5l)");
        c.setCalorie(0);
        c.setPrezzo(3);
        return c;
    }

    @Bean("margherita")
    public Pizza margherita() {
        Pizza p = new Pizza();
        p.setNome("Pizza Margherita");
        p.setCalorie(600);
        List<Topping> lista = p.getToppings();
        lista.add(cheese());
        lista.add(tomato());
        p.setPrezzo(lista.stream().mapToDouble(Topping::getPrezzo).sum() + prezzoBase);
        p.setToppings(lista);
        return p;
    }

    @Bean("cipolle")
    public Pizza cipolle() {
        Pizza p = new Pizza();
        p.setNome("Pizza e Cipolle");
        p.setCalorie(650);
        List<Topping> lista = p.getToppings();
        lista.add(cheese());
        lista.add(tomato());
        lista.add(onions());
        p.setPrezzo(lista.stream().mapToDouble(Topping::getPrezzo).sum() + prezzoBase);
        p.setToppings(lista);
        return p;
    }

    @Bean("pancetta")
    public Pizza pancetta() {
        Pizza p = new Pizza();
        p.setNome("Pizza con Pancetta");
        p.setCalorie(700);
        List<Topping> lista = p.getToppings();
        lista.add(cheese());
        lista.add(tomato());
        lista.add(ham());
        p.setPrezzo(lista.stream().mapToDouble(Topping::getPrezzo).sum() + prezzoBase);
        p.setToppings(lista);
        return p;
    }

    @Bean("cc")
    public double getCostoCoperto(@Value("${ordine.costo_coperto}") String c) {
        return Double.parseDouble(c);
    }

    @Bean("lista_toppings")
    public List<Topping> listaToppings() {
        return List.of(salami(), ham(), cheese(), tomato(), onions());
    }


}
