
package com.sub.Demo4.04;

public class SilverCard extends Card{
    public SilverCard(String card, String name, String phone, double money) {
        super(card, name, phone, money);
    }

    @Override
    public void consume(double money) {
        System.out.println("現在のシルバーカード消費：" + money);
        System.out.println("割引後の価格：" + money * 0.9);
        if(getMoney() < money * 0.9){
            System.out.println("現在の残高：" + getMoney() + "、残高不足です！チャージしてください！");
            return; // メソッドを終了！
        }
        // シルバーカードのアカウント残高を更新。
        setMoney(getMoney() - money * 0.9);
        System.out.println("現在のシルバーカード残高：" + getMoney());
    }
}