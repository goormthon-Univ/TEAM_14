package com.mungge.orumi.domain.emotion.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
@Table(name = "user_count")
@Entity
public class EmotionCount {
    @Id
    @Column(name = "user_id")
    private String userId;
    private int peaceCnt = 0;
    private int excitedCnt = 0;
    private int happyCnt = 0;
    private int tiredCnt = 0;
    private int angryCnt = 0;
    private int sadCnt = 0;

}
