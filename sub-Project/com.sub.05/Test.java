import package com.sub.05;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        // 目标：オブジェクト指向プログラミングでスマートホーム制御システムを実現。
        // 役割：デバイス（シーリングライト、テレビ、洗濯機、フロアウィンドウ、....）
        // 搭載機能：オンとオフ。
        // 誰が制御する：スマート制御システム（シングルトンオブジェクト）、デバイスのオンとオフを制御呼び出し。
        // 1、デバイスクラスを定義：デバイスオブジェクトを作成し、家のデバイスを表す。
        // 2、これらのデバイスオブジェクトを準備し、配列に格納し、家庭全体のデバイスを表す。
        JD[] jds = new JD[4];
        jds[0] = new TV("シャオミテレビ", true);
        jds[1] = new WashMachine("美的洗濯機", false);
        jds[2] = new Lamp("欧灯", true);
        jds[3] = new Air("美的エアコン", false);

        // 3、各デバイスにオン/オフ機能を設定。インターフェースを定義し、JDにスイッチ機能を実装させる。
        // 4、スマート制御システムオブジェクトを作成し、デバイスのオン/オフを制御。
        SmartHomeControl smartHomeControl = new SmartHomeControl();
        // 5、テレビを制御。
        // smartHomeControl.control(jds[0]);

        // 6 、ユーザー操作を促す、a、全デバイスの現在状況を表示。b、ユーザーに操作を選択させる。
        // 全デバイスのオン/オフ状況を出力。
        while (true) {
            smartHomeControl.printAllStatus(jds);
            System.out.println("操作するデバイスを選択してください：");
            Scanner sc = new Scanner(System.in);
            String command = sc.next();
            switch (command){
                case "1":
                    smartHomeControl.control(jds[0]);
                    break;
                case "2":
                    smartHomeControl.control(jds[1]);
                    break;
                case "3":
                    smartHomeControl.control(jds[2]);
                    break;
                case "4":
                    smartHomeControl.control(jds[3]);
                    break;
                case "exit":
                    System.out.println("アプリを終了します!");
                    return;
                default:
                    System.out.println("入力エラー、再入力してください");
            }
        }
    }
}
