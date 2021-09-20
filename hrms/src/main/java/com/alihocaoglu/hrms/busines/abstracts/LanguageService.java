package com.alihocaoglu.hrms.busines.abstracts;

import java.util.List;

import com.alihocaoglu.hrms.core.utilities.results.DataResult;
import com.alihocaoglu.hrms.core.utilities.results.Result;
import com.alihocaoglu.hrms.entities.concretes.Language;
import com.alihocaoglu.hrms.entities.dtos.LanguageForSetDto;

public interface LanguageService {
    public Result addLanguage(LanguageForSetDto languageForSetDto);
    public Result deleteLanguage(int languageId);
    public DataResult<List<Language>> getByCvId(int cvId);
}
