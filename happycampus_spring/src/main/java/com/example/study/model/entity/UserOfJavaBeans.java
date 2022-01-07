package com.example.study.model.entity;

public class UserOfJavaBeans {

    private Long id;  // 얘는 필수

    private String account; // 필수
    private String password; // 필수
    private String phoneNumber; // 필수

    private int age = 0; // 선택
    private String email = ""; // 선택


    public UserOfJavaBeans() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
