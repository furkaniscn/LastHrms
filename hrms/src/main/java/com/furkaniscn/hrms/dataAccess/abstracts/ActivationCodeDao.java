package com.furkaniscn.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.furkaniscn.hrms.entities.concretes.ActivationCode;

public interface ActivationCodeDao extends JpaRepository<ActivationCode,Integer> {
    ActivationCode findByCode(String code);
}
