package com.hrms.busines.abstracts;

import java.util.List;

import com.hrms.core.utilities.results.DataResult;
import com.hrms.entities.concretes.User;

public interface UserService {
    DataResult<List<User>> getAll();
    DataResult<User> getByEmail(String email);
}
