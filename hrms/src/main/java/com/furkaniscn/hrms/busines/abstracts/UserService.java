package com.furkaniscn.hrms.busines.abstracts;

import java.util.List;

import com.furkaniscn.hrms.core.utilities.results.DataResult;
import com.furkaniscn.hrms.entities.concretes.User;

public interface UserService {
    DataResult<List<User>> getAll();
    DataResult<User> getByEmail(String email);
}
