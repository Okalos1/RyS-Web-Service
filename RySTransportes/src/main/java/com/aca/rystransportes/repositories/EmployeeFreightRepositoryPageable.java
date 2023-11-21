package com.aca.rystransportes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.aca.rystransportes.models.entities.EmployeeFreight;
import com.aca.rystransportes.models.entities.Freights;
import com.aca.rystransportes.models.entities.User;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface EmployeeFreightRepositoryPageable extends PagingAndSortingRepository<EmployeeFreight, Integer> {
	List<EmployeeFreight> findAllByUserOrderByFreightdateDescIdEmployeeFreightAsc(PageRequest info, User user);
	//findBy
}
