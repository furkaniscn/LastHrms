package com.hrms.busines.abstracts;

import com.hrms.entities.concretes.User;

public interface EmailService {
    void sendVerifyEmail(User user,String code);
}
