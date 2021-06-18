package com.hrms.busines.abstracts;

import java.util.List;

import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.Result;
import com.hrms.entities.concretes.School;
import com.hrms.entities.dtos.SchoolForSerDto;

public interface SchoolService {
    public Result addSchool(SchoolForSerDto schoolForSerDto);
    public Result deleteSchool(int schoolId);
    public DataResult<List<School>> getByCvId(int cvId);
}
