package com.furkaniscn.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.furkaniscn.hrms.busines.abstracts.WorkPlaceService;
import com.furkaniscn.hrms.core.utilities.results.DataResult;
import com.furkaniscn.hrms.entities.concretes.WorkPlace;

import java.util.List;

@RestController
@RequestMapping("/workPlace")
@CrossOrigin
public class WorkPlacesController {

    private WorkPlaceService workPlaceService;

    @Autowired
    public WorkPlacesController(WorkPlaceService workPlaceService) {
        this.workPlaceService = workPlaceService;
    }

    @GetMapping("/getAll")
    public DataResult<List<WorkPlace>> getAll(){
        return this.workPlaceService.getAll();
    }
}
