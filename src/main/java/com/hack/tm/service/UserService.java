package com.hack.tm.service;

import com.hack.tm.domain.User;

public interface UserService {

    User retrieveUserInfo(Long id) throws Exception;
}
