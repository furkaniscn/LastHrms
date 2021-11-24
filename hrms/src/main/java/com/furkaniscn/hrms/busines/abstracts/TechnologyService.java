package com.furkaniscn.hrms.busines.abstracts;

import java.util.List;

import com.furkaniscn.hrms.core.utilities.results.DataResult;
import com.furkaniscn.hrms.core.utilities.results.Result;
import com.furkaniscn.hrms.entities.concretes.Technology;
import com.furkaniscn.hrms.entities.dtos.TechnologyForSerDto;

public interface TechnologyService {
    public Result addTechnology(TechnologyForSerDto technologyForSerDto);
    public Result deleteTechnology(int technologyId);
    public DataResult<List<Technology>> getByCvId(int cvId);
}
