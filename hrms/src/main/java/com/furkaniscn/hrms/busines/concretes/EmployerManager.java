package com.furkaniscn.hrms.busines.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.furkaniscn.hrms.busines.abstracts.*;
import com.furkaniscn.hrms.core.utilities.results.*;
import com.furkaniscn.hrms.dataAccess.abstracts.EmployerDao;
import com.furkaniscn.hrms.dataAccess.abstracts.EmployerUpdateDao;
import com.furkaniscn.hrms.dataAccess.abstracts.StaffDao;
import com.furkaniscn.hrms.entities.concretes.Employer;
import com.furkaniscn.hrms.entities.concretes.EmployerUpdate;
import com.furkaniscn.hrms.entities.dtos.EmployerForRegisterDto;

import java.time.LocalDate;
import java.util.List;
import java.util.regex.Pattern;

@Service
public class EmployerManager implements EmployerService {

	private EmployerDao employerDao;
	private UserService userService;
	private ActivationByStaffService activationByStaffService;
	private ActivationCodeService activationCodeService;
	private EmailService emailService;
	private EmployerUpdateDao employerUpdateDao;
	private StaffDao staffDao;

	@Autowired
	public EmployerManager(EmployerDao employerDao, UserService userService,
			ActivationByStaffService activationByStaffService, ActivationCodeService activationCodeService,
			EmailService emailService, EmployerUpdateDao employerUpdateDao, StaffDao staffDao) {
		this.employerDao = employerDao;
		this.userService = userService;
		this.activationByStaffService = activationByStaffService;
		this.activationCodeService = activationCodeService;
		this.emailService = emailService;
		this.employerUpdateDao = employerUpdateDao;
		this.staffDao = staffDao;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(), "Data listelendi");
	}

	@Override
	public DataResult<Employer> getByEmail(String email) {
		return new SuccessDataResult<Employer>(this.employerDao.findByEmail(email), "Listelendi");
	}

	@Override
	public Result add(EmployerForRegisterDto employerDto) {
		if (!employerDto.getPassword().equals(employerDto.getRePassword())) {
			return new ErrorResult("??ifreler e??le??miyor");
		}
		Employer employer = new Employer();
		employer.setEmail(employerDto.getEmail());
		employer.setPassword(employerDto.getPassword());
		employer.setCompanyName(employerDto.getCompanyName());
		employer.setWebSite(employerDto.getWebSite());
		employer.setPhoneNumber(employerDto.getPhoneNumber());
		employer.setWaitingUpdate(false);

		if (userService.getByEmail(employer.getEmail()).getData() != null) {
			return new ErrorResult("Bu email zaten kay??tl??");
		} else if (!isEmailValid(employer.getEmail())) {
			return new ErrorResult("Ge??erli bir email giriniz");
		} else if (!employer.getEmail().endsWith(employer.getWebSite())) {
			return new ErrorResult("Web siteniz ve emailinizin domaini ayn?? olmal??d??r");
		} else if (employer.getPassword().length() <= 6) {
			return new ErrorResult("??ifre 6 karakterden uzun olmal??d??r.");
		} else if (employer.getPhoneNumber().length() < 10) {
			return new ErrorResult("Ge??erli bir telefon numaras?? giriniz.");
		} else if (employer.getCompanyName().length() <= 2) {
			return new ErrorResult("??irket ad?? 2 karakterden uzun olmal??d??r");
		}

		employer.setActive(false);
		employer.setMailVerify(false);
		this.employerDao.save(employer);

		this.emailService.sendVerifyEmail(employer, this.activationCodeService.createActivationCode(employer));
		activationByStaffService.createActivationByStaff(employer);

		return new SuccessResult(employer.getEmail() + " Adresine do??rulama kodunuz g??nderildi");

	}

	@Override
	public DataResult<Employer> getById(int id) {
		if (!this.employerDao.existsById(id)) {
			return new ErrorDataResult<Employer>("B??yle bir i??veren yok");
		}
		return new SuccessDataResult<Employer>(this.employerDao.getById(id), "Data listelendi");
	}

	@Override
	public Result update(EmployerUpdate employerUpdate) {
		employerUpdate.setId(0);
		employerUpdate.setCreateDay(LocalDate.now());

		if (employerUpdate.getCompanyName().length() < 2) {
			return new ErrorResult("??irket ad?? 2 karakterden k??sa olamaz");
		} else if (employerUpdate.getPhoneNumber().length() != 11) {
			return new ErrorResult("Telefon numaras?? 11 haneli olmal??d??r");
		} else if (!isEmailValid(employerUpdate.getEmail())) {
			return new ErrorResult("Ge??erli bir mail adresi giriniz");
		} else if (this.employerDao.existsById(employerUpdate.getEmployerId())) {
			return new ErrorResult(("B??yle bir i??veren yok"));
		}
		Employer employer = this.employerDao.getById(employerUpdate.getEmployerId());
		this.employerUpdateDao.save(employerUpdate);
		employer.setWaitingUpdate(true);
		this.employerDao.save(employer);
		return new SuccessResult("G??ncelleme iste??i g??nderildi personelin onay?? ard??ndan g??r??n??r olacakt??r");
	}

	@Override
	public Result verifyUpdate(int employerUpdateId, int staffId) {
		if (!this.employerUpdateDao.existsById(employerUpdateId)) {
			return new ErrorResult("B??yle bir g??ncelleme talebi yok");
		} else if (!this.staffDao.existsById(staffId)) {
			return new ErrorResult("B??yle bir personel yok");
		}
		EmployerUpdate employerUpdate = this.employerUpdateDao.getById(employerUpdateId);
		Employer employer = this.employerDao.getById(employerUpdate.getEmployerId());

		employerUpdate.setVerifyed(true);
		employerUpdate.setStaffId(staffId);
		employerUpdate.setVerifyDate(LocalDate.now());
		this.employerUpdateDao.save(employerUpdate);

		employer.setEmail(employerUpdate.getEmail());
		employer.setCompanyName(employerUpdate.getCompanyName());
		employer.setPhoneNumber(employerUpdate.getPhoneNumber());
		employer.setWebSite(employerUpdate.getWebSite());
		employer.setWaitingUpdate(false);
		this.employerDao.save(employer);
		return new SuccessResult("Bilgiler g??ncellendi");
	}

	private final String EMAIL_PATTERN = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+.(com|org|net|edu|gov|mil|biz|info|mobi)(.[A-Z]{2})?$";

	public boolean isEmailValid(String emailInput) {
		Pattern pattern = Pattern.compile(EMAIL_PATTERN, Pattern.CASE_INSENSITIVE);
		return pattern.matcher(emailInput).find();
	}

}