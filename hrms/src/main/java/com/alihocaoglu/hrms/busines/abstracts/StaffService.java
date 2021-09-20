package com.alihocaoglu.hrms.busines.abstracts;

import java.util.List;

import com.alihocaoglu.hrms.core.utilities.results.DataResult;
import com.alihocaoglu.hrms.core.utilities.results.Result;
import com.alihocaoglu.hrms.entities.concretes.Staff;
import com.alihocaoglu.hrms.entities.dtos.StaffUpdateDto;

public interface StaffService {
	public Result create(Staff staff);

	public DataResult<List<Staff>> getAll();

	public Result update(StaffUpdateDto staffUpdateDto);
}