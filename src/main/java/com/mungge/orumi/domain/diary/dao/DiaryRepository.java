package com.mungge.orumi.domain.diary.dao;

import com.mungge.orumi.domain.diary.domain.Diary;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface DiaryRepository extends JpaRepository<Diary, Long> {

    public Diary findByUserIdAndDate(String userId, LocalDate date);
}
