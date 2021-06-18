package com.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrms.entities.concretes.WorkPlace;

public interface WorkPlaceDao extends JpaRepository<WorkPlace,Integer> {
}
