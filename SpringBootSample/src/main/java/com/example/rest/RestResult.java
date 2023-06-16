package com.example.rest;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;

//RESTから返されるクラス
@Data
@AllArgsConstructor
public class RestResult {
	
	//リターンコード（正常終了、またはバリデーションエラーの値を格納）
	private int result;
	
	//エラーマップ（Key:フィールド名、value:エラーメッセージ）
	//バリデーションエラーになったフィールドとエラーメッセージを格納
	private Map<String, String> errors;
	
}
