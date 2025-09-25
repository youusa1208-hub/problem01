package com.sub.Demo8;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ThreadTest {
    public static void main(String[] args) {
//         目標：マルチスレッドの総合ケースを完成する
//         紅包雨ゲーム、ある企業には100名の従業員がおり、従業員の社員番号は順に1, 2, 3, 4, ... から100までである。
//         会社が忘年会イベントを開催し、イベント中に紅包雨セクションがあり、合計200個の紅包雨を配布する必要がある。
//         そのうち小紅包は[1 - 30]元の間で、総占有可能性は80%、大紅包は[31-100]元で、総占有可能性は20%。
//         分析：100人の従業員は実際には100個のスレッドであり、200個の紅包を競争する。
        List<Integer> redPackets = getRedPackets();
//        2、スレッドクラスを定義し、100個のスレッドオブジェクトを作成し、同じコレクションを競争させる。
        for (int i = 0; i < 100; i++){
            new GetRedPacket(redPackets, "人" + i).start();
        }

    }
    //    この200個のランダムな紅包を準備して返却し、Listコレクションに格納して返す。
    public static List<Integer> getRedPackets(){
        Random r = new Random();
//        そのうち小紅包は[1 - 30]元の間で、総占有可能性は80%、大紅包は[31-100]元で、総占有可能性は20%。
        List<Integer> redPacket = new ArrayList<>();
        for (int i = 0; i < 160; i++) {
            redPacket.add(r.nextInt(30) + 1);
        }
        for (int i = 0; i < 40; i++){
            redPacket.add(r.nextInt(70) + 31);
        }
        return redPacket;
    }
}
