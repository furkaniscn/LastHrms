package com.furkaniscn.hrms.busines.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.furkaniscn.hrms.busines.abstracts.ActivationByStaffService;
import com.furkaniscn.hrms.core.utilities.results.ErrorResult;
import com.furkaniscn.hrms.core.utilities.results.Result;
import com.furkaniscn.hrms.core.utilities.results.SuccessResult;
import com.furkaniscn.hrms.dataAccess.abstracts.ActivationByStaffDao;
import com.furkaniscn.hrms.dataAccess.abstracts.EmployerDao;
import com.furkaniscn.hrms.entities.concretes.ActivationByStaff;
import com.furkaniscn.hrms.entities.concretes.Employer;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;

@Service
public class ActivationByStaffManager implements ActivationByStaffService {

    private ActivationByStaffDao activationByStaffDao;
    private EmployerDao employerDao;

    @Autowired
    public ActivationByStaffManager(ActivationByStaffDao activationByStaffDao,EmployerDao employerDao) {
        this.activationByStaffDao = activationByStaffDao;
        this.employerDao=employerDao;
    }

    @Override
    public void createActivationByStaff(Employer employer) {
        ActivationByStaff activationByStaff=new ActivationByStaff();
        activationByStaff.setEmployeId(employer.getId());
        activationByStaff.setVerifyed(false);
        activationByStaff.setStaffId(null);
        activationByStaffDao.save(activationByStaff);
    }

    @Override
    public Result activateEmployer(int employerId,int staffId) {

        try {
            Employer employer = employerDao.getById(employerId);
            ActivationByStaff activationByStaff = activationByStaffDao.findByEmployeId(employerId);

            employer.setActive(true);
            employerDao.save(employer);

            activationByStaff.setVerifyed(true);
            activationByStaff.setVerifyDate(LocalDate.now());
            activationByStaff.setStaffId(staffId);
            activationByStaffDao.save(activationByStaff);

        }catch (EntityNotFoundException exception){
            return new ErrorResult("Hatal?? id");
        }
        return new SuccessResult("Kullan??c?? aktif edildi");
    }
}
