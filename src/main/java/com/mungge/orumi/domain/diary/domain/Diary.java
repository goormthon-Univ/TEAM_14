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
    @Column(name = "dairy_id")
    private String dairyId;

    @Column(name = "user_id")
    private String userId;

    @Convert(converter = EmotionConverter.class)
    private Emotion emotion;
    private String text;
    private String image;   // Image or File 엔티티 따로 구현해야할듯

    @CreatedDate
    @Convert(converter = LocalDateConverter.class)
    private LocalDate date;

    public Diary(String userId, Emotion emotion, String text, String image) {
        this.userId = userId;
        this.emotion = emotion;
        this.text = text;
        this.image = image;
        date = LocalDate.now();
    }
}
