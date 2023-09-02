package com.example.crudfix.domain.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "more_info")
@Data
public class MoreInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idx;
    private String id;
    private String email;
    private String phone_number;
    private String address;
    private String upt_date;
}
