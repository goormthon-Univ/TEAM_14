package com.mungge.orumi.domain.user.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Data
@Getter
@Setter
@Entity
public class User {
    @Id
    private String id;
    private String nickname;
    private String password;
    private LocalDate joinDate;
}
