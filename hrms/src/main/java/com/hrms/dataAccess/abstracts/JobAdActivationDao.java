package com.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrms.entities.concretes.JobAdActivation;

public interface JobAdActivationDao extends JpaRepository<JobAdActivation,Integer> {
}
