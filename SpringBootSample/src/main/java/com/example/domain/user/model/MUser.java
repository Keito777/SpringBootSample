package com.example.domain.user.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

//ユーザーマスタテーブルのエンティティクラス（DBのデータを保管するクラス）
//エンティティクラス：DBテーブルのレコードをJavaのオブジェクトとして扱うためのクラス
@Data
@Entity
@Table(name="m_user") //マッピングしたいテーブル名を設定
public class MUser {
	@Id //主キー
    private String userId;
	
    private String password;
    private String userName;
    private Date birthday;
    private Integer age;
    private Integer gender;
    private Integer departmentId;
    private String role;
    
    @ManyToOne(optional = true) //MUserが多、Departmentが1の関係（属性で結合方法の指定）
    @JoinColumn(insertable=false, updatable=false, name="departmentId") //結合するカラムの指定
    private Department department;
    
    @OneToMany //MUserが1、Salaryが多の関係
    @JoinColumn(insertable=false, updatable=false, name="userId")
    private List<Salary> salaryList;
}