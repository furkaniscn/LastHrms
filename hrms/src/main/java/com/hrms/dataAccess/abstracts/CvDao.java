package com.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrms.entities.concretes.Cv;

public interface CvDao extends JpaRepository<Cv,Integer> {
    Cv findByCandidateId(int id);
}
