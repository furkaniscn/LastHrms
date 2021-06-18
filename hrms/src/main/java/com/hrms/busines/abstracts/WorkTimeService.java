package com.hrms.busines.abstracts;

import java.util.List;

import com.hrms.core.utilities.results.DataResult;
import com.hrms.entities.concretes.WorkTime;

public interface WorkTimeService {
    public DataResult<List<WorkTime>> getAll();
}
