package com.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrms.entities.concretes.WorkTime;

public interface WorkTimeDao extends JpaRepository<WorkTime,Integer> {
}
