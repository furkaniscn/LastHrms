package com.furkaniscn.hrms.busines.abstracts;

import java.util.List;

import com.furkaniscn.hrms.core.utilities.results.DataResult;
import com.furkaniscn.hrms.core.utilities.results.Result;
import com.furkaniscn.hrms.entities.concretes.JobAdFavorites;

public interface JobAdFavoritesService {
	public DataResult<List<JobAdFavorites>> getByCandidateId(int candidateId);

	public Result addFavorite(int candidateId, int jobAdId);
}