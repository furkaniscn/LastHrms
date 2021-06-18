package com.hrms.busines.abstracts;

import java.util.List;

import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.Result;
import com.hrms.entities.concretes.Staff;

public interface StaffService {
    public Result create(Staff staff);
    public DataResult<List<Staff>> getAll();
}
