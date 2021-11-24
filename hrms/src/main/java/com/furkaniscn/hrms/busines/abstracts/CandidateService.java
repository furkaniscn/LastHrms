package com.furkaniscn.hrms.busines.abstracts;

import java.util.List;

import com.furkaniscn.hrms.core.utilities.results.DataResult;
import com.furkaniscn.hrms.core.utilities.results.Result;
import com.furkaniscn.hrms.entities.concretes.Candidate;
import com.furkaniscn.hrms.entities.dtos.CandidateForRegisterDto;

public interface CandidateService {
    DataResult<List<Candidate>> getAll();
    DataResult<Candidate> getByNationalNumber(String nationalNumber);
    DataResult<Candidate> getByEmail(String email);
    Result add(CandidateForRegisterDto candidateForRegisterDto);
}
