package com.alihocaoglu.hrms.busines.abstracts;

import java.util.List;

import com.alihocaoglu.hrms.core.utilities.results.DataResult;
import com.alihocaoglu.hrms.core.utilities.results.Result;
import com.alihocaoglu.hrms.entities.concretes.JobAdFavorites;

public interface JobAdFavoritesService {
	public DataResult<List<JobAdFavorites>> getByCandidateId(int candidateId);

	public Result addFavorite(int candidateId, int jobAdId);
}