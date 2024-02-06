package it.epicode.w5d2;

import it.epicode.w5d2.bean.Drink;
import it.epicode.w5d2.bean.Pizza;
import it.epicode.w5d2.components.Ordine;
import it.epicode.w5d2.components.Tavolo;
import it.epicode.w5d2.enums.StatoOrdine;
import it.epicode.w5d2.enums.StatoTavolo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.util.List;
@Component
public class Runner implements CommandLineRunner {
    private static final Logger logger
            = LoggerFactory.getLogger(Runner.class);

    @Override
    public void run(String... args) throws Exception {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(W5d2Application.class);
        Ordine o = context.getBean(Ordine.class);
        Tavolo t = context.getBean(Tavolo.class);
        t.setNumero(10);
        t.setNumMaxCoperti(8);
        o.setNumCoperti(5);
        if (o.getNumCoperti() > t.getNumMaxCoperti()) {
            logger.error("L'ordine ha un numero di coperti superiore al numero massimo del tavolo");
        }
        t.setStato(StatoTavolo.LIBERO);
        o.setNumero(13293);
        o.setStato(StatoOrdine.IN_CORSO);
        o.setComanda(List.of(context.getBean("margherita", Pizza.class),
                context.getBean("pancetta", Pizza.class), context.getBean("lemonade", Drink.class)
                ));
        o.setOra(LocalTime.now());
        o.setCostoCoperto(context.getBean("cc", Double.class));
        o.calcolaCostoTotale();
        System.out.println(o.getCostoTotale());
        logger.info("Ordine numero: " + o.getNumero());
        logger.info("Tavolo: " + o.getTavolo());
        logger.info("Stato: " + o.getStato());
        logger.info("Comanda:");
        o.getComanda().forEach(System.out::println);
        logger.info("Numero coperti: " + o.getNumCoperti());
        logger.info("Costo totale: €" + o.getCostoTotale());

    }
}
