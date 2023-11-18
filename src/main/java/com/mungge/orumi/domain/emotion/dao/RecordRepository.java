package com.mungge.orumi.domain.emotion.dao;

import com.mungge.orumi.domain.diary.domain.Diary;
import com.mungge.orumi.domain.diary.domain.Emotion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface RecordRepository extends JpaRepository<Diary, Long> {
    /* 감정 하늘 (감정별로 총 6번 쿼리 실행)
     * SELECT COUNT(*)
     * FROM dairy
     * WHERE user_id = {userId} AND emotion = {emotion} AND date >= {start} AND date <= {today}
     */
    public int countAllByUserIdAndEmotionAndDateBetween(String userId, Emotion emotion, LocalDate start, LocalDate today);

    /*
     * 감정 날씨 (오름차순으로 가입한 날 이후의 모든 감정 출력)
     * SELECT emotion FROM Dairy
     * WHERE user_id = {userId} AND date >= {start} AND date <= {today}
     * ORDER BY date ASC
     */
    public List<Diary> findByUserIdAndDateBetween(String userId, LocalDate start, LocalDate today);

    public Diary findByUserIdAndDate(String userId, LocalDate now);

    public int countDiaryByUserIdAndEmotionAndDateBetween(String userId, Emotion emotion, LocalDate start, LocalDate today);
}
