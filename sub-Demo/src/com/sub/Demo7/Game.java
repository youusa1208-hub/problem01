package com.sub.Demo7;

import com.sub.Room;

public class Game {
    public static void main(String[] args) {
//        目標：闘地主ゲームの開発
//        1、各カードはオブジェクトであり、カードクラスを定義する。
//        2、ゲームルームもオブジェクトである：ルームクラスを定義する（54枚のカード、開始起動）
        Room r =new Room();
        r.start();
    }
}
