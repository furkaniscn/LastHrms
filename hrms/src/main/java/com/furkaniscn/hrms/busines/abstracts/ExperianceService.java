package com.furkaniscn.hrms.busines.abstracts;


import java.util.List;

import com.furkaniscn.hrms.core.utilities.results.DataResult;
import com.furkaniscn.hrms.core.utilities.results.Result;
import com.furkaniscn.hrms.entities.concretes.Experiance;
import com.furkaniscn.hrms.entities.dtos.ExperianceForSetDto;

public interface ExperianceService{
    Result add(ExperianceForSetDto experianceForSetDto);
    Result delete(int experianceId);
    DataResult<List<Experiance>> getByCvId(int id);
}
