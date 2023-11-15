package com.aca.rystransportes.repositories;


import com.aca.rystransportes.models.entities.Freights;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface FreightsRepository extends JpaRepository<Freights, Integer> {
    List<Freights> findAllByOrderByDateDesc();
}
