package com.furkaniscn.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.furkaniscn.hrms.busines.abstracts.ImageService;
import com.furkaniscn.hrms.core.services.CloudinaryService;
import com.furkaniscn.hrms.core.utilities.results.Result;
import com.furkaniscn.hrms.dataAccess.abstracts.CvDao;

@RestController
@RequestMapping("/api/images")
@CrossOrigin
public class ImagesController {

	private CloudinaryService cloudinaryService;
	private ImageService imageService;
	private CvDao cvDao;

	@Autowired
	public ImagesController(CloudinaryService cloudinaryService, ImageService imageService, CvDao cvDao) {
		this.cloudinaryService = cloudinaryService;
		this.imageService = imageService;
		this.cvDao = cvDao;
	}

	@GetMapping("/getAll")
	public ResponseEntity<?> getAll() {
		return ResponseEntity.ok(this.imageService.getAll());
	}

	@PostMapping("/upload")
	public ResponseEntity<?> upload(@RequestParam MultipartFile multipartFile, @RequestParam int cvId) {
		Result result = this.imageService.update(multipartFile, cvId);
		if (!result.isSuccess()) {
			return ResponseEntity.badRequest().body(result);
		}
		return ResponseEntity.ok(result);
	}

	@DeleteMapping("/delete")
	public ResponseEntity<?> delete(@RequestParam int id) {
		Result result = this.imageService.delete(id);
		if (!result.isSuccess()) {
			return ResponseEntity.badRequest().body(result);
		}
		return ResponseEntity.ok(result);
	}
}
