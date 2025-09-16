package com.sub.04;
//
public class GoldCard extends Card{
    public GoldCard(String card, String name, String phone, double money) {
        super(card, name, phone, money);
    }

    @Override
    public void consume(double money) {
        System.out.println("現在のゴールドカード消費：" + money);
        System.out.println("割引後の価格：" + money * 0.8);
        if(getMoney() < money * 0.8){
            System.out.println("現在の残高：" + getMoney() + "、残高不足です！チャージしてください！");
            return; // メソッドを終了！
        }
        // ゴールドカードのアカウント残高を更新。
        setMoney(getMoney() - money * 0.8);
        System.out.println("現在のゴールドカード残高：" + getMoney());
        // 消費が200以上の場合、独自機能を呼び出して洗車券を印刷。
        if(money * 0.8 >= 200){
            printTicket();
        }else {
            System.out.println("今回の消費額が200未満のため、無料洗車サービスをご利用いただけません！");
        }
    }

    // 洗車券を印刷。
    public void printTicket() {
        System.out.println("ご利用ありがとうございました。洗車券を印刷してください。");
    }
}
