package com.alihocaoglu.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alihocaoglu.hrms.entities.concretes.User;

public interface UserDao extends JpaRepository<User,Integer> {
    User findByEmail(String email);
}
