package com.hack.tm.service;

import com.hack.tm.domain.Address;
import com.hack.tm.domain.User;
import com.hack.tm.vo.DaumMapAddrParam;

public interface UserService {

    User findByUser(Long id) throws Exception;

    Address getUserAddress(User user) throws Exception;

    Address insertUserAddress(Long id, DaumMapAddrParam param) throws Exception;
}
