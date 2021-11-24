package com.furkaniscn.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.furkaniscn.hrms.busines.abstracts.JobAdFavoritesService;
import com.furkaniscn.hrms.core.utilities.results.DataResult;
import com.furkaniscn.hrms.core.utilities.results.Result;
import com.furkaniscn.hrms.entities.concretes.JobAdFavorites;

import java.util.List;

@RestController
@RequestMapping("/jobAdFavorites")
@CrossOrigin
public class JobAdFavoritesController {

	private JobAdFavoritesService jobAdFavoritesService;

	@Autowired
	public JobAdFavoritesController(JobAdFavoritesService jobAdFavoritesService) {
		this.jobAdFavoritesService = jobAdFavoritesService;
	}

	@GetMapping("/getByCandidateId")
	public ResponseEntity<?> getByCandidateId(@RequestParam int candidateId) {
		DataResult<List<JobAdFavorites>> result = this.jobAdFavoritesService.getByCandidateId(candidateId);
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().body(result);
	}

	@PostMapping("/addFavorite")
	public ResponseEntity<?> addFavorite(@RequestParam int candidateId, @RequestParam int jobAdId) {
		Result result = this.jobAdFavoritesService.addFavorite(candidateId, jobAdId);
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().body(result);
	}
}