package com.example.form;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

// フォームにバインドするためのクラス
//フォームからの入力値を保存しておく役割
//各アノテーションは、バリデーション用
//アノテーションのgroups引数は、GroupOeder.javaで設定したバリデーションとの紐付けを行うもの
@Data
public class SignupForm {
	
    @NotBlank(groups = ValidGroup1.class)
    @Email(groups = ValidGroup2.class)
    private String userId;

    @NotBlank(groups = ValidGroup1.class)
    @Length(min = 4, max = 100, groups = ValidGroup2.class)
    @Pattern(regexp = "^[a-zA-Z0-9]+$", groups = ValidGroup2.class)
    private String password;

	@NotBlank(groups = ValidGroup1.class)
    private String userName;

    //patternに設定したフォーマットで入力された場合にDate型に変換する
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    @NotNull(groups = ValidGroup1.class)
    private Date birthday;

    @Min(value = 20, groups = ValidGroup2.class)
    @Max(value = 100, groups = ValidGroup2.class)
    private Integer age;

    @NotNull(groups = ValidGroup1.class)
    private Integer gender;
}
