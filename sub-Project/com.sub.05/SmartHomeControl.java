import package com.sub.05;
// スマートホーム制御システムクラス。
public class SmartHomeControl {
    // ポリモーフィズム。
    public void control(JD jd) {
        System.out.println(jd.getName() + "の現在の状態：" + (jd.isStatus() ? "オン" : "オフ！"));
        System.out.println("操作を開始してください。。。。。");
        jd.press(); // スイッチを押す。
        System.out.println(jd.getName() + "の状態はすでに：" + (jd.isStatus() ? "オン" : "オフ！"));
    }

    public void printAllStatus(JD[] jds) {
        // forループを使用し、インデックスに基づいて各デバイスを走査。
        for (int i = 0; i < jds.length; i++) {
            JD jd = jds[i];
            System.out.println((i + 1) + "," + jd.getName() + "の現在の状態：" + (jd.isStatus() ? "オン" : "オフ！"));
        }
    }
}
