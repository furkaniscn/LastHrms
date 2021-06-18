package com.hrms.busines.abstracts;

import java.util.List;

import com.hrms.core.utilities.results.DataResult;
import com.hrms.entities.concretes.WorkPlace;

public interface WorkPlaceService {
    public DataResult<List<WorkPlace>> getAll();
}
