package com.employee.bean;

//ユーザー情報にはユーザー名、パスワード、ログイン名が含まれます。

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String username;//ユーザー名
    private String password;//パスワード
    private String loginname;//ログイン名

}
