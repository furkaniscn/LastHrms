package com.furkaniscn.hrms.busines.abstracts;

import java.util.List;

import com.furkaniscn.hrms.core.utilities.results.DataResult;
import com.furkaniscn.hrms.core.utilities.results.Result;
import com.furkaniscn.hrms.entities.concretes.Cv;

public interface CvService {
	public Result add(int candidateId);

	public DataResult<List<Cv>> getAll();

	public DataResult<Cv> getByCvId(int cvId);

	public DataResult<Cv> getByCandidateId(int candidateId);

	public Result updateGithub(String githublink, int cvId);

	public Result deleteGithub(int cvId);

	public Result updateLinkedin(String linkedinlink, int cvId);

	public Result deleteLinkedin(int cvId);

	public Result updateBiography(String biography, int cvId);

	public Result deleteBiography(int cvId);
}
