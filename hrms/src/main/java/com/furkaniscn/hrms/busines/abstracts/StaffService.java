package com.furkaniscn.hrms.busines.abstracts;

import java.util.List;

import com.furkaniscn.hrms.core.utilities.results.DataResult;
import com.furkaniscn.hrms.core.utilities.results.Result;
import com.furkaniscn.hrms.entities.concretes.Staff;
import com.furkaniscn.hrms.entities.dtos.StaffUpdateDto;

public interface StaffService {
	public Result create(Staff staff);

	public DataResult<List<Staff>> getAll();

	public Result update(StaffUpdateDto staffUpdateDto);
}