package com.mungge.orumi.domain.user.dao;

import com.mungge.orumi.domain.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    public User findById(String Id);
}
