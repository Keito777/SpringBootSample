package com.example.form;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

// フォームをバインドするためのクラス
@Data
public class SignupForm {

    private String userId;

    private String password;

    private String userName;

    //patternに設定したフォーマットで入力された場合にDate型に変換する
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private Date birthday;

    private Integer age;

    private Integer gender;
}
