package com.alihocaoglu.hrms.busines.abstracts;

import java.util.List;

import com.alihocaoglu.hrms.core.utilities.results.DataResult;
import com.alihocaoglu.hrms.entities.concretes.WorkTime;

public interface WorkTimeService {
    public DataResult<List<WorkTime>> getAll();
}
