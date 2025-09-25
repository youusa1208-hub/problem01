package com.sub.Demo1;

import java.util.Random;
import java.util.Scanner;

public class test2 {
    public static void main(String[] args) {
//        数字当てゲーム
        guess();
    }

    public static void guess() {

//        方法一
//        Math.random()は0.1の範囲の乱数を生成する
//        （int）Math.random()*100 ==> [0,99]+1 => [1,100]
//        int num = (int)(Math.random() * 100) + 1; // 1から100までのランダムな数を生成

//       方法二
        Random r = new Random();// 乱数を生成するインスタンス
        int lucknumber = r.nextInt(100) + 1; // [0,99]+1 => [1,100] 1から100までのランダムな数を生成

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("数字を入力してください");
            int input = sc.nextInt();

            if (input < lucknumber) {
                System.out.println("もっと大きい");
            } else if (input > lucknumber) {
                System.out.println("もっと小さい");
            } else {
                System.out.println("正解！");
                break; // 正解したらループを終了
            }
        }
    }
}
