package com.furkaniscn.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.furkaniscn.hrms.busines.abstracts.ActivationCodeService;
import com.furkaniscn.hrms.core.utilities.results.Result;

@RestController
@RequestMapping("/api/activationcode")
@CrossOrigin
public class ActivationCodeController {
	private ActivationCodeService activationCodeService;

	@Autowired
	public ActivationCodeController(ActivationCodeService activationCodeService) {
		this.activationCodeService = activationCodeService;
	}

	@GetMapping("/active/{code}")
	public ResponseEntity<?> activateUser(@PathVariable String code) {
		Result result = this.activationCodeService.activateUser(code);
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().body(result);
	}
}
