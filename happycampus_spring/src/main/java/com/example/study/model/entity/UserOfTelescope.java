package com.example.study.model.entity;

import com.example.study.model.enumclass.UserStatus;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class UserOfTelescope {

    private Long id;  // 얘는 필수

    private String account; // 필수
    private String password; // 필수
    private String phoneNumber; // 필수

    private int age; // 선택
    private String email; // 선택


    public UserOfTelescope(Long id, String account, String password, String phoneNumber) {
        this(id, account, password, phoneNumber, 19);
    }

    public UserOfTelescope(Long id, String account, String password, String phoneNumber, int age) {
        this(id, account, password, phoneNumber, 0, "");
    }

    public UserOfTelescope(Long id, String account, String password, String phoneNumber, int age, String email) {
        this.id = id;
        this.account = account;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
    }
}
