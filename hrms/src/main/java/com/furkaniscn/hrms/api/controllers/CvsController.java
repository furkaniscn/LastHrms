package com.furkaniscn.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.furkaniscn.hrms.busines.abstracts.CvService;
import com.furkaniscn.hrms.core.utilities.results.DataResult;
import com.furkaniscn.hrms.core.utilities.results.Result;
import com.furkaniscn.hrms.entities.concretes.Cv;
import com.furkaniscn.hrms.entities.dtos.CvForSetDto;

import java.util.List;

@RestController
@RequestMapping("/api/cv")
@CrossOrigin
public class CvsController {

	private CvService cvService;

	@Autowired
	public CvsController(CvService cvService) {
		this.cvService = cvService;
	}

	@GetMapping("/getall")
	public DataResult<List<Cv>> getAll() {
		return this.cvService.getAll();
	}

	@GetMapping("/getByCvId")
	public ResponseEntity<?> getByCvId(@RequestParam int cvId) {
		DataResult<Cv> result = this.cvService.getByCvId(cvId);
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().body(result);
	}

	@GetMapping("/getByCandidateId")
	public ResponseEntity<?> getByCandidateId(@RequestParam int candidateId) {
		DataResult<Cv> result = this.cvService.getByCandidateId(candidateId);
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().body(result);
	}

	@PutMapping("/updateGithub")
	public ResponseEntity<?> updateGithub(@RequestParam String githublink, @RequestParam int cvId) {
		Result result = this.cvService.updateGithub(githublink, cvId);
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().body(result);
	}

	@DeleteMapping("/deleteGithub")
	public ResponseEntity<?> deleteGithub(@RequestParam int cvId) {
		Result result = this.cvService.deleteGithub(cvId);
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().body(result);
	}

	@PutMapping("/updateLinkedin")
	public ResponseEntity<?> updateLinkedin(@RequestParam String linkedinlink, @RequestParam int cvId) {
		Result result = this.cvService.updateLinkedin(linkedinlink, cvId);
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().body(result);
	}

	@DeleteMapping("/deleteLinkedin")
	public ResponseEntity<?> deleteLinkedin(@RequestParam int cvId) {
		Result result = this.cvService.deleteLinkedin(cvId);
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().body(result);
	}

	@PutMapping("/updateBiography")
	public ResponseEntity<?> updateBiography(@RequestParam String biography, @RequestParam int cvId) {
		Result result = this.cvService.updateBiography(biography, cvId);
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().body(result);
	}

	@DeleteMapping("/deleteBiography")
	public ResponseEntity<?> deleteBiography(@RequestParam int cvId) {
		Result result = this.cvService.deleteBiography(cvId);
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().body(result);
	}
}