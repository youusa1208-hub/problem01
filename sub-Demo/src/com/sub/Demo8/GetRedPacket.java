package com.sub.Demo8;

import java.util.List;

public class GetRedPacket extends Thread {
    private List<Integer> redPackets;

    public GetRedPacket(List<Integer> redPackets, String name) {
        super(name);
        this.redPackets = redPackets;
    }

    @Override
    public void run() {
//        個人がredPacketコレクションからお金を取得
        String name = Thread.currentThread().getName();
        while(true) {
            synchronized (redPackets) {
                if(redPackets.size() == 0) {
                    break;
                }
//            ランダムなインデックスで红包を取得
                int index = (int) (Math.random() * redPackets.size());
                Integer money = redPackets.remove(index);
                System.out.println(name + "が红包を取得：" + money);
                if (redPackets.size() == 0) {
                    System.out.println(name + "がすべて取得完了");
                }
            }
        }
    }
}
