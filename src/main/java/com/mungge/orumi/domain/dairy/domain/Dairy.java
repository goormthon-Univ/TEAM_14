package com.mungge.orumi.domain.dairy.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Data
@Getter
@Setter
@Entity
public class Dairy {
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
    private LocalDateTime date;
}
