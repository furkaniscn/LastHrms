package com.hrms.busines.abstracts;

import java.util.List;

import com.hrms.core.utilities.results.DataResult;
import com.hrms.entities.concretes.City;

public interface CityService {
    public DataResult<List<City>> getAll();
}
