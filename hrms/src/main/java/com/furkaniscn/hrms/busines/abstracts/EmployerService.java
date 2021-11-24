package com.furkaniscn.hrms.busines.abstracts;

import java.util.List;

import com.furkaniscn.hrms.core.utilities.results.DataResult;
import com.furkaniscn.hrms.core.utilities.results.Result;
import com.furkaniscn.hrms.entities.concretes.Employer;
import com.furkaniscn.hrms.entities.concretes.EmployerUpdate;
import com.furkaniscn.hrms.entities.dtos.EmployerForRegisterDto;

public interface EmployerService {
	DataResult<List<Employer>> getAll();

	DataResult<Employer> getByEmail(String email);

	Result add(EmployerForRegisterDto employerDto);

	DataResult<Employer> getById(int id);

	Result update(EmployerUpdate employerUpdate);

	Result verifyUpdate(int employerUpdateId, int staffId);
}