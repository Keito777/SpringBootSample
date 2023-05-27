package com.example.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {
	
	@Autowired
	private HelloService service;
	
	@GetMapping("/hello")
	public String getHello() {
		
		// hello.htmlをレスポンス
		return "hello";
	}
	
	@PostMapping("/hello")
	public String postRequest(@RequestParam("text1") String str, Model model) {
		
		//画面（フォーム）から受け取った文字列をデフォルトクラスのModelに登録
		model.addAttribute("sample", str);
		
		//response.htmlをレスポンス
		return "hello/response";
	}
	
	@PostMapping("/hello/db")
	public String postDbRequest(@RequestParam("text2") String id, Model model) {
		
		//1件検索
		Employee employee = service.getEmployee(id);
		
		//検索結果をModelに登録
		//ここでは、クラス型の変数をModelに登録
		model.addAttribute("employee", employee);
		
		//db.htmlをレスポンス
		return "hello/db";
	}

}
