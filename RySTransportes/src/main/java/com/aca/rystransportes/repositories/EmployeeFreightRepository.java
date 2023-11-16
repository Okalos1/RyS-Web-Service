package com.aca.rystransportes.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.aca.rystransportes.models.entities.EmployeeFreight;
import com.aca.rystransportes.models.entities.Freights;

public interface EmployeeFreightRepository extends JpaRepository<EmployeeFreight, Integer> {
	List<EmployeeFreight> findAllByFreight(Freights freight);
}
