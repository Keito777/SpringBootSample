package com.example.application.service;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

//ユーザー登録画面（新規登録画面）用のサービスクラス
@Service
public class UserApplicationService {
	
	//messages.propertiesから値を取得するオブジェクト
	@Autowired
	private MessageSource messageSource;
	
	//性別のMapを作成する（ラジオボタン用）
	public Map<String, Integer> getGenderMap(Locale locale){
		Map<String, Integer> genderMap = new LinkedHashMap<>();
		
		//messages.propertiesから値を取得
		//getMessage(キー名, 埋め込みパラメーター, ロケール（国）)
		String male = messageSource.getMessage("male", null, locale);
		String female = messageSource.getMessage("female", null, locale);
		
		//オブジェクトにキーと値を追加する（put(キー, 値)）
		genderMap.put(male, 1);
		genderMap.put(female, 2);
		
		return genderMap;
	}

}
