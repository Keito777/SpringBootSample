package com.example.domain.user.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

//部署テーブルのエンティティクラス
@Data
@Entity //JPAにエンティティクラスと認識させる
@Table(name="m_department")
public class Department {
	@Id
	private Integer departmentId;
	private String departmentName;

}
