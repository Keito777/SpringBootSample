package com.example.form;

import jakarta.validation.GroupSequence;

//バリデーションの順番を設定するインターフェース
//以下のアノテーションを使って、左のインターフェースの順にバリデーションを行う
@GroupSequence({ ValidGroup1.class, ValidGroup2.class })
public interface GroupOrder {

}
