package com.aca.rystransportes.repositories;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.aca.rystransportes.models.entities.Freights;

public interface FreightsRepositoryPageable extends PagingAndSortingRepository<Freights, Integer>{
	List<Freights> findAllByOrderByDateDescIdFreightAsc(PageRequest info);
}
