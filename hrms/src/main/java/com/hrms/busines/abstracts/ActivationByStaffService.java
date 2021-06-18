package com.hrms.busines.abstracts;

import com.hrms.core.utilities.results.Result;
import com.hrms.entities.concretes.Employer;

public interface ActivationByStaffService {
    void createActivationByStaff(Employer employer);
    Result activateEmployer(int employerId,int staffId);
}
