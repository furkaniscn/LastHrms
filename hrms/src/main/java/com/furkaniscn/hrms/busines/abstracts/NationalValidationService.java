package com.furkaniscn.hrms.busines.abstracts;

import com.furkaniscn.hrms.entities.concretes.Candidate;

public interface NationalValidationService {
    boolean validate(Candidate candidate);
}
