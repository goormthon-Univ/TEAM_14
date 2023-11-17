package com.mungge.orumi.domain.diary.domain;

import com.mungge.orumi.global.common.LocalDateConverter;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;

@Data
@Getter
@Setter
@Entity
@NoArgsConstructor
public class Diary {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "diary_id")
    private Long diaryId;

    @Column(name = "user_id")
    private String userId;

    @Convert(converter = EmotionConverter.class)
    private Emotion emotion;
    private String text;
    private Long imageId;   // Image or File 엔티티 따로 구현해야할듯

    @CreatedDate
    @Convert(converter = LocalDateConverter.class)
    private LocalDate date;

    public Diary(String userId, Emotion emotion, String text, Long imageId) {
        this.userId = userId;
        this.emotion = emotion;
        this.text = text;
        this.imageId = imageId;
        date = LocalDate.now();
    }
}
