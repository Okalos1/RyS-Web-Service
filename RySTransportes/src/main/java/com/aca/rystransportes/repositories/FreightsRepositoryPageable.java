package com.aca.rystransportes.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.aca.rystransportes.models.entities.Freights;

public interface FreightsRepositoryPageable extends PagingAndSortingRepository<Freights, Integer>{

}
