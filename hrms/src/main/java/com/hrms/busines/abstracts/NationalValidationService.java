package com.hrms.busines.abstracts;

import com.hrms.entities.concretes.Candidate;

public interface NationalValidationService {
    boolean validate(Candidate candidate);
}
