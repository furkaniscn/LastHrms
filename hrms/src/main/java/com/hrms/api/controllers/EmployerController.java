package com.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.hrms.busines.abstracts.EmployerService;
import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.Result;
import com.hrms.entities.concretes.Employer;
import com.hrms.entities.dtos.EmployerForRegisterDto;

import java.util.List;

@RestController
@RequestMapping("/api/employer")
@CrossOrigin
public class EmployerController {

    private EmployerService employerService;

    @Autowired
    public EmployerController(EmployerService employerService) {
        this.employerService = employerService;
    }

    @GetMapping("/getall")
    public DataResult<List<Employer>> getAll(){
        return this.employerService.getAll();
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody EmployerForRegisterDto employerForRegisterDto){
        Result result=this.employerService.add(employerForRegisterDto);
        if(result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @GetMapping("/getById")
    DataResult<Employer> getById(@RequestParam int id){
        return this.employerService.getById(id);
    }
}
