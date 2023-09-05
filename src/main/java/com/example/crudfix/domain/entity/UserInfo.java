package com.example.crudfix.domain.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;

@Data
@Table(name = "user_info")
@Entity
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idx;
    @NotNull
    private String id;
    @NotNull
    private String nickname;
    @NotNull
    private String password;
    @NotNull
    private String reg_date;
    @NotNull
    private char flag;
}

