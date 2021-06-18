package com.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.hrms.busines.abstracts.SchoolService;
import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.Result;
import com.hrms.entities.concretes.School;
import com.hrms.entities.dtos.SchoolForSerDto;

import java.util.List;

@RestController
@RequestMapping("/api/school")
@CrossOrigin
public class SchoolsContoller {

    private SchoolService schoolService;

    @Autowired
    public SchoolsContoller(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @PostMapping("/addSchool")
    public Result addSchool(@RequestBody SchoolForSerDto schoolForSerDto){
        return this.schoolService.addSchool(schoolForSerDto);
    }

    @DeleteMapping("/deleteSchool")
    public Result deleteSchool(@RequestParam int schoolId){
        return this.schoolService.deleteSchool(schoolId);
    }

    @GetMapping("/getByCvId")
    public DataResult<List<School>> getByCvId(@RequestParam int cvId){
        return this.schoolService.getByCvId(cvId);
    }
}
