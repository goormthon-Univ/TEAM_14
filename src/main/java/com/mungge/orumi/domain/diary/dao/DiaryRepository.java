package com.mungge.orumi.domain.diary.dao;

import com.mungge.orumi.domain.diary.domain.Diary;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class DiaryRepository {
    private final EntityManager entityManager;

    public void save(Diary diary) {
        entityManager.persist(diary);
    }

    public Diary findOne(Long id){
        return entityManager.find(Diary.class, id);
    }
}
