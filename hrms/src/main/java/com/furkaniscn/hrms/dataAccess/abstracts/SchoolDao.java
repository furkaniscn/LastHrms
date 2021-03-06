package com.furkaniscn.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.furkaniscn.hrms.entities.concretes.School;

import java.util.List;

public interface SchoolDao extends JpaRepository<School,Integer> {
    List<School> findByCvId(int id);
}
