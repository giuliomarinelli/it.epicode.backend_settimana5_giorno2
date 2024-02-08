package it.epicode.w5d2.repositories;

import it.epicode.w5d2.bean.MenuItem;
import it.epicode.w5d2.bean.Topping;
import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface MIRepository extends JpaRepository<MenuItem, UUID> {
    public List<MenuItem> findByNomeContainingIgnoreCase(String nome);

    public List<MenuItem> findByPrezzo(double prezzo);

    @Query("SELECT COUNT(t) FROM Topping t")
    public long quantiToppingsCiSono();



}
