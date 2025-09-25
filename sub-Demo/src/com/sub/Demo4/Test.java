package com.sub.Demo4

.04;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        // 目标：ガソリンスタンド支払いミニプログラム。
        // 1、カードクラスを作成し、ゴールドカードまたはシルバーカードオブジェクトを作成できるようにし、車主のデータをカプセル化する。
        // 2、カード親クラスを定義：Card、ゴールドカードとシルバーカードの共通属性とメソッドを定義する。
        // 3、ゴールドカードクラスを定義し、Cardクラスを継承：ゴールドカードは消費メソッドをオーバーライド必須（2割引優待）、独自機能として洗車券印刷がある。
        // 3、シルバーカードクラスを定義し、Cardクラスを継承：シルバーカードは消費メソッドをオーバーライド必須（1割引優待）
        // 4、ゴールドカードを発行：ゴールドカードオブジェクトを作成。独立した業務（支払端末）に委託して：預金、消費を行う。
        GoldCard goldCard = new GoldCard("鄂A860MM", "dlei", "18665616520", 5000);
        goldCard.deposit(100); // 更に100を預金
        pay(goldCard);

        // 4、シルバーカードを発行：シルバーカードオブジェクトを作成。独立した業務（支払端末）に委託して：預金、消費を行う。
        SilverCard silverCard = new SilverCard("粤A88888", "dlei", "18984724244", 2000);
        pay(silverCard);
    }

    // 支払端末：一つのメソッドでカードを読み取る： ゴールドカードを受け取ることも可能、シルバーカードを受け取ることも可能。
    public static void pay(Card c){
        System.out.println("カードをスワイプしてください、現在の消費金額を入力してください：");
        Scanner sc = new Scanner(System.in);
        double money = sc.nextDouble();
        c.consume(money);
    }
}
