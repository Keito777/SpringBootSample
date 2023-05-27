package com.example.hello;

import lombok.Data;

//リポジトリクラスの検索結果を格納しておくクラス
//サービスクラスによって、リポジトリクラスから取得したデータを保存しておく
@Data
public class Employee {
	private String employeeId;
	private String employeeName;
	private int employeeAge;
}
