package com.furkaniscn.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.furkaniscn.hrms.entities.concretes.Image;

import java.util.List;

public interface ImageDao extends JpaRepository<Image,Integer> {
    List<Image> findByOrderById();
    Image findByCvId(int id);
}
