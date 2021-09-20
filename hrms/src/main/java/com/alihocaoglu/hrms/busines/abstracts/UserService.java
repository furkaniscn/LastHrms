package com.alihocaoglu.hrms.busines.abstracts;

import java.util.List;

import com.alihocaoglu.hrms.core.utilities.results.DataResult;
import com.alihocaoglu.hrms.entities.concretes.User;

public interface UserService {
    DataResult<List<User>> getAll();
    DataResult<User> getByEmail(String email);
}
