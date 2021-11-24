package com.furkaniscn.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.furkaniscn.hrms.entities.concretes.JobAdActivation;

public interface JobAdActivationDao extends JpaRepository<JobAdActivation,Integer> {
}
