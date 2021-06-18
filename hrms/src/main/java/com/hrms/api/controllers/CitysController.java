package com.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrms.busines.abstracts.CityService;
import com.hrms.core.utilities.results.DataResult;
import com.hrms.entities.concretes.City;

import java.util.List;

@RestController
@RequestMapping("/city")
@CrossOrigin
public class CitysController {

    private CityService cityService;

    @Autowired
    public CitysController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping("/getAll")
    public DataResult<List<City>> getAll(){
        return this.cityService.getAll();
    }
}
