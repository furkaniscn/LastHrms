package com.alihocaoglu.hrms.busines.concretes;

import org.springframework.stereotype.Service;

import com.alihocaoglu.hrms.busines.abstracts.NationalValidationService;
import com.alihocaoglu.hrms.entities.concretes.Candidate;

@Service
public class MernisManager implements NationalValidationService {


    @Override
    public boolean validate(Candidate candidate) {
        if(candidate.getNationalNumber().length()!=11){
            return false;
        }
        return true;
    }
}