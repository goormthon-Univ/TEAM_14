package com.mungge.orumi.domain.user.application;

import com.mungge.orumi.domain.user.dao.UserRepository;
import com.mungge.orumi.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User findUser(String id) {
        return userRepository.findById(id);
    }

    public LocalDate findJoinDate(String id) {
        return userRepository.findById(id).getJoinDate();
    }
}
