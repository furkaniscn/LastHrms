package com.furkaniscn.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.furkaniscn.hrms.entities.concretes.Language;

import java.util.List;

public interface LanguageDao extends JpaRepository<Language,Integer> {
    List<Language> findByCvId(int id);
}
