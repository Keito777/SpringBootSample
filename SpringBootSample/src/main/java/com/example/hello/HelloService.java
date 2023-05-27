package com.example.hello;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//サービスクラス
//リポジトリークラスを使ってSQLの実行結果を取得している
@Service
public class HelloService {
	
	//@Autowired：自動でクラスをインスタンス化してくれるアノテーション
	@Autowired
	private HelloRepository repository;
	
	//従業員を1人取得する
	public Employee getEmployee(String id) {
		//検索
		//Map<キーの型, 値の型>
		Map<String, Object> map = repository.findById(id);
		
		//Mapから値を取得
		//（Object型をString, Integerにキャストしている）
		String employeeId = (String) map.get("id");
		String name = (String) map.get("name");
		int age = (Integer) map.get("age");
		
		//Employeeクラスに値をセット
		Employee employee = new Employee();
		employee.setEmployeeId(employeeId);
		employee.setEmployeeName(name);
		employee.setEmployeeAge(age);
		
		return employee;
	}
}
