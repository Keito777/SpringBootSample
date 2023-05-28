package com.example.controller;

import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.application.service.UserApplicationService;

//ユーザー登録画面（新規作成画面）のコントローラーを作成
@Controller
@RequestMapping("/user")
public class SignupController {
	
	@Autowired
	private UserApplicationService userApplicationService;
	
	//ユーザー登録画面を表示
	//Model, Localクラスのオブジェクトを受け取る意味？（毎回、同じオブジェクト？）
	@GetMapping("/signup")
	public String getSignup(Model model, Locale locale) {
		
		//性別を取得
		Map<String, Integer> genderMap = userApplicationService.getGenderMap(locale);
		//男:1, 女:2の２要素をmodelに保存
		model.addAttribute("genderMap", genderMap);
		
		//ユーザー登録画面に遷移
		return "user/signup";
	}
	
	//ユーザー登録処理
	@PostMapping("/signup")
	public String postSignup() {
		
		//ログイン画面にリダイレクト
		return "redirect:/login";
	}

}
