package com.alihocaoglu.hrms.busines.abstracts;

import java.util.List;

import com.alihocaoglu.hrms.core.utilities.results.DataResult;
import com.alihocaoglu.hrms.core.utilities.results.Result;
import com.alihocaoglu.hrms.entities.concretes.Technology;
import com.alihocaoglu.hrms.entities.dtos.TechnologyForSerDto;

public interface TechnologyService {
    public Result addTechnology(TechnologyForSerDto technologyForSerDto);
    public Result deleteTechnology(int technologyId);
    public DataResult<List<Technology>> getByCvId(int cvId);
}
