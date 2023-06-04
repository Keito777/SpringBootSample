package com.example.controller;

import java.util.Locale;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.application.service.UserApplicationService;
import com.example.domain.user.model.MUser;
import com.example.domain.user.service.UserService;
import com.example.form.GroupOrder;
import com.example.form.SignupForm;

import lombok.extern.slf4j.Slf4j;

//ユーザー登録画面（新規作成画面）のコントローラーを作成
@Controller
@RequestMapping("/user")
@Slf4j //log変数（static変数）が用意され、そのメソッドを使えば、簡単にログを出力できる。
public class SignupController {
	
	@Autowired
	private UserApplicationService userApplicationService;
	
	 @Autowired
	private UserService userService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	//ユーザー登録画面を表示
	//Model, Localクラスのオブジェクトを受け取る意味？（毎回、同じオブジェクト？）
	//@ModelAttribute→自動でModelにインスタンスを登録してくれる（これを自動で定義してくれる→model.addAttribute("signupForm", form);）
	  //キーの名前は、クラス名の先頭を小文字にしたものになる
	@GetMapping("/signup")
	public String getSignup(Model model, Locale locale, @ModelAttribute SignupForm form) {
		
		//性別を取得
		Map<String, Integer> genderMap = userApplicationService.getGenderMap(locale);
		//男:1, 女:2の２要素をmodelに保存
		model.addAttribute("genderMap", genderMap);
		
		//ユーザー登録画面に遷移
		return "user/signup";
	}
	
	//ユーザー登録処理
	@PostMapping("/signup")
    public String postSignup(Model model, Locale locale,
            @ModelAttribute @Validated(GroupOrder.class) SignupForm form,
            BindingResult bindingResult)  {
		
		//入力チェック結果
		if(bindingResult.hasErrors()) {
			//NG:ユーザー登録画面に戻る
			return getSignup(model, locale, form);
		}
		
		//infoレベルのログを出力する（コンソールに）（@Slf4jによって使用可能になる）
		log.info(form.toString());
		
		//formをMUserクラスに変換(modelMapper.map()によってフィールドの内容をMUserにコピーする)
		MUser user = modelMapper.map(form, MUser.class);
		
		//ユーザー登録
		userService.signup(user);
		
		//ログイン画面にリダイレクト
		return "redirect:/login";
		
	}

}
