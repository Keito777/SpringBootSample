package com.example.domain.user.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.Data;

//給料テーブル
@Embeddable //主キーのクラスの定義
@Data
public class SalaryKey implements Serializable {
    private String userId;
    private String yearMonth;
}
