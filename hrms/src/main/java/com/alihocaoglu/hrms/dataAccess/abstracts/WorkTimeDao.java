package com.alihocaoglu.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alihocaoglu.hrms.entities.concretes.WorkTime;

public interface WorkTimeDao extends JpaRepository<WorkTime,Integer> {
}
