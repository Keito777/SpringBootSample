package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.domain.user.model.MUser;

//JPAのリポジトリ（JpaRepositoryを継承することで定義できる）
public interface UserRepository extends JpaRepository<MUser, String>{

	/** ログインユーザー検索 */
	//@QueryでSQLを実行できるメソッドが定義できる
	//テーブル名、カラム名は、Javaのクラス名、フィールド名を使う。（JPQL言語）
    @Query("select user"
            + " from MUser user"
            + " where userId = :userId")
    public MUser findLoginUser(@Param("userId") String userId);

    /** ユーザー更新 */
    @Modifying
    @Query("update MUser"
            + " set"
            + "   password = :password"
            + "   , userName = :userName"
            + " where"
            + "   userId = :userId")
    public Integer updateUser(@Param("userId") String userId,
            @Param("password") String password,
            @Param("userName") String userName);
}
