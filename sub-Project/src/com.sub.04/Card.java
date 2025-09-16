package com.sub.04;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// lombok技術により、クラスに自動的にgetter setterメソッド、引数なしコンストラクタ、toStringメソッドなどを追加できる。
@Data // @Dataアノテーションにより、getter setterメソッド、引数なしコンストラクタ、toStringメソッドなどを自動生成できる
@NoArgsConstructor
@AllArgsConstructor
public class Card {
    private String carId; // 車牌番号
    private String name;
    private String phone;
    private double money; // 残高

    // 事前チャージ金額。
    public void deposit(double money) {
        this.money += money;
    }

    // 消費金額。
    public void consume(double money) {
        this.money -= money;
    }
}
