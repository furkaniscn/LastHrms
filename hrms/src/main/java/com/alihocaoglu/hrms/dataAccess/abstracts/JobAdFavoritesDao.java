package com.alihocaoglu.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alihocaoglu.hrms.entities.concretes.JobAdFavorites;

import java.util.List;

public interface JobAdFavoritesDao extends JpaRepository<JobAdFavorites, Integer> {
	List<JobAdFavorites> findByCandidateId(int id);
}