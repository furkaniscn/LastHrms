package com.furkaniscn.hrms.busines.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.furkaniscn.hrms.busines.abstracts.JobAdFavoritesService;
import com.furkaniscn.hrms.core.utilities.results.*;
import com.furkaniscn.hrms.dataAccess.abstracts.CandidateDao;
import com.furkaniscn.hrms.dataAccess.abstracts.JobAdDao;
import com.furkaniscn.hrms.dataAccess.abstracts.JobAdFavoritesDao;
import com.furkaniscn.hrms.entities.concretes.JobAd;
import com.furkaniscn.hrms.entities.concretes.JobAdFavorites;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobAdFavoritesManager implements JobAdFavoritesService {

	private JobAdFavoritesDao jobAdFavoritesDao;
	private CandidateDao candidateDao;
	private JobAdDao jobAdDao;

	@Autowired
	public JobAdFavoritesManager(JobAdFavoritesDao jobAdFavoritesDao, CandidateDao candidateDao, JobAdDao jobAdDao) {
		this.jobAdFavoritesDao = jobAdFavoritesDao;
		this.candidateDao = candidateDao;
		this.jobAdDao = jobAdDao;
	}

	@Override
	public DataResult<List<JobAdFavorites>> getByCandidateId(int candidateId) {
		if (!this.candidateDao.existsById(candidateId)) {
			return new ErrorDataResult<List<JobAdFavorites>>("Böyle bir kullanıcı yok");
		}
		return new SuccessDataResult<List<JobAdFavorites>>(this.jobAdFavoritesDao.findByCandidateId(candidateId),
				"Data listelendi");
	}

	@Override
	public Result addFavorite(int candidateId, int jobAdId) {

		if (!this.candidateDao.existsById(candidateId)) {
			return new ErrorResult("Böyle bir kullanıcı yok");
		} else if (!this.jobAdDao.existsById(jobAdId)) {
			return new ErrorResult("Böyle bir ilan yok");
		}

		JobAdFavorites jobAdFavorites = new JobAdFavorites();
		jobAdFavorites.setCandidate(this.candidateDao.getById(candidateId));
		jobAdFavorites.setJobAd(this.jobAdDao.getById(jobAdId));
		this.jobAdFavoritesDao.save(jobAdFavorites);
		return new SuccessResult("İlan facorilere eklendi");
	}
}