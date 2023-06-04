package com.example.domain.user.model;

import java.util.Date;

import lombok.Data;

//ユーザーマスタテーブルのエンティティクラス（DBのデータを保管するクラス）
//エンティティクラス：DBテーブルのレコードをJavaのオブジェクトとして扱うためのクラス
@Data
public class MUser {
    private String userId;
    private String password;
    private String userName;
    private Date birthday;
    private Integer age;
    private Integer gender;
    private Integer departmentId;
    private String role;
}