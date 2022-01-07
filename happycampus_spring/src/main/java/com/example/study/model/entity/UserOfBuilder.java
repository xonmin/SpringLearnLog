package com.example.study.model.entity;

public class UserOfBuilder {

    private final Long id;  // 얘는 필수
    private final String account; // 필수
    private final String password; // 필수
    private final String phoneNumber; // 필수
    private final int age; // 선택
    private final String email; // 선택

    public UserOfBuilder(Builder builder) {
        id = builder.id;
        account = builder.account;
        password = builder.password;
        phoneNumber = builder.phoneNumber;
        age = builder.age;
        email = builder.email;
    }

    public static class Builder {
        private Long id;  // 얘는 필수
        private String account; // 필수
        private String password; // 필수
        private String phoneNumber; // 필수
        private int age = 0; // 선택
        private String email = ""; // 선택

        public Builder(Long id, String account, String password, String phoneNumber) {
            this.id = id;
            this.account = account;
            this.password = password;
            this.phoneNumber = phoneNumber;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public UserOfBuilder build() { //마무리
            return new UserOfBuilder(this);
        }
    }


}
