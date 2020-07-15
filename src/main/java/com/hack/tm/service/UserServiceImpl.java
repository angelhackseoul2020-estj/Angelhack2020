package com.hack.tm.service;

import com.hack.tm.domain.User;
import com.hack.tm.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.zip.DataFormatException;

@Service
//@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;

    public UserServiceImpl(@Autowired UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public User retrieveUserInfo(Long id) throws DataFormatException {
        return userRepository.findById(id).orElseThrow();
    }
}
