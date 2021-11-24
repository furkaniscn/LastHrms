package com.furkaniscn.hrms.busines.abstracts;

import java.util.List;

import com.furkaniscn.hrms.core.utilities.results.DataResult;
import com.furkaniscn.hrms.core.utilities.results.Result;
import com.furkaniscn.hrms.entities.concretes.JobAd;
import com.furkaniscn.hrms.entities.dtos.JobAdDto;
import com.furkaniscn.hrms.entities.dtos.JobAdFilter;

public interface JobAdService {
	Result create(JobAdDto jobAdDto);

	Result setPasssive(int jobAdId);

	Result setActiveAndConfirm(int jobAdId, int staffId);

	DataResult<List<JobAd>> getAll();

	DataResult<JobAd> getByJobAdId(int id);

	DataResult<List<JobAd>> getActiveAds();

	DataResult<List<JobAd>> getActiveAndOrderLastDate();

	DataResult<List<JobAd>> getActiveAndCompanyId(int id);

	DataResult<List<JobAd>> getByIsActiveAndPageNumberAndFilter(int pageNo, int pageSize, JobAdFilter jobAdFilter);
}