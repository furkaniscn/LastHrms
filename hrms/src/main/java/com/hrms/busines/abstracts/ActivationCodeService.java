package com.hrms.busines.abstracts;

import com.hrms.core.utilities.results.Result;
import com.hrms.entities.concretes.ActivationCode;
import com.hrms.entities.concretes.User;

public interface ActivationCodeService {
    ActivationCode getByCode(String code);
    String createActivationCode(User user);
    Result activateUser(String code);
}
