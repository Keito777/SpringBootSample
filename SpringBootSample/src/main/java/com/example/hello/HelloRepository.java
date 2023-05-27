package com.example.hello;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

//DBからデータを検索するリポジトリークラス
//JDBCを使ってselect文を実行する
@Repository
public class HelloRepository {
	
	//@Autowired：自動でクラスをインスタンス化してくれるアノテーション
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public Map<String, Object> findById(String id){
		//SELECT文
		String query = "SELECT * FROM employee WHERE id=?";
		
		//検索実行
		//Mapnのキーには、カラム名。値には、データが入っている。
		Map<String, Object> employee = jdbcTemplate.queryForMap(query, id);
		
		return employee;
	}

}
