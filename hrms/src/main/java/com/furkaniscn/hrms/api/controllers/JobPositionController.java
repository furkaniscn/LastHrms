package com.furkaniscn.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.furkaniscn.hrms.busines.abstracts.JobPositionService;
import com.furkaniscn.hrms.core.utilities.results.DataResult;
import com.furkaniscn.hrms.core.utilities.results.Result;
import com.furkaniscn.hrms.entities.concretes.JobPosition;

import java.util.List;

@RestController
@RequestMapping("/api/jobpositions")
@CrossOrigin
public class JobPositionController {

    private JobPositionService jobPositionService;

    @Autowired
    public JobPositionController(JobPositionService jobPositionService) {
        this.jobPositionService = jobPositionService;
    }

    @GetMapping("/getall")
    public DataResult<List<JobPosition>> getAll(){
        return this.jobPositionService.getAll();
    }


    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody JobPosition jobPosition){
        Result result=this.jobPositionService.add(jobPosition);
        if(result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }
}
