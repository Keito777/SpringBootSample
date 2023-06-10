package com.example.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.domain.user.model.MUser;

//ユーザーマスタテーブル用のリポジトリ（検索用クラス）
//MyBatisでリポジトリーを作成するには、Javaのインターフェースに@Mapperをつける
@Mapper
public interface UserMapper {

    //ユーザー登録
    public int insertOne(MUser user);
    
    //ユーザー取得（複数件）
    public List<MUser> findMany(MUser user);
    
    //ユーザー取得（１件）
    public MUser findOne(String userId);
    
    //ユーザー更新（１件）
    public void updateOne(@Param("userId") String userId,
    		@Param("password") String password,
    		@Param("userName") String userName);
    
    //ユーザー削除（１件）
    public int deleteOne(@Param("userId") String userId);
}
