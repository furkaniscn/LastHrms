package com.furkaniscn.hrms.busines.abstracts;

import com.furkaniscn.hrms.entities.concretes.User;

public interface EmailService {
    void sendVerifyEmail(User user,String code);
}
