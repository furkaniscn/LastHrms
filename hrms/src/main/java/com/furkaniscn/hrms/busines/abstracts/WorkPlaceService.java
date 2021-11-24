package com.furkaniscn.hrms.busines.abstracts;

import java.util.List;

import com.furkaniscn.hrms.core.utilities.results.DataResult;
import com.furkaniscn.hrms.entities.concretes.WorkPlace;

public interface WorkPlaceService {
    public DataResult<List<WorkPlace>> getAll();
}
