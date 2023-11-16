package com.mungge.orumi.domain.user.application;

import com.mungge.orumi.domain.user.dao.UserRepository;
import com.mungge.orumi.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User findUser(String id) {
        return userRepository.findById(id);
    }
}
