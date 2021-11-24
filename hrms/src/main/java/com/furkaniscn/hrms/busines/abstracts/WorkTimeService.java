package com.furkaniscn.hrms.busines.abstracts;

import java.util.List;

import com.furkaniscn.hrms.core.utilities.results.DataResult;
import com.furkaniscn.hrms.entities.concretes.WorkTime;

public interface WorkTimeService {
    public DataResult<List<WorkTime>> getAll();
}
