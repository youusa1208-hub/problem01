package com.Demo.Demo4test;

import java.util.*;

public class Room {
    //    1，准备好54张牌，给房间使用:定义一个集合容器装54张牌
    private List<Card> allCards = new ArrayList<>();
//    2，初始化54张牌进去。
{
//    3，准备点数
    String[] sizes = {"3","4","5","6","7","8","9","10","J","Q","K","2","A"};
//    String[] sizes = {"A","3","4","5","6","7","8","9","10","J","Q","K","2"};
//    4，准备花色
    String[] colors = {"♠","♥","♣","♦"};
//    5，组合点数和花色成为牌对象，加入到集合中取
    int num = 0;
    for (String size : sizes) {
        num++;
        for (String color : colors) {
//            6,创建牌对象
            Card card = new Card(size,color, num);
//            7，加入到集合中去
            allCards.add(card);
        }
    }
//    allCards.add(new Card("","小王"));
//    allCards.add(new Card("","大王"));
    Collections.addAll(allCards,new Card("","小王",++num),new Card("","大王",++num));
    System.out.println("新牌是:" + allCards);

}

    public void start(){

//    8,洗牌，随机打乱集合中的牌
        Collections.shuffle(allCards);
        System.out.println("洗牌后:" + allCards);

//     9，发牌：定义三个玩家："玩家1"="lhc", "玩家2"= "lhj", "玩家3"= "lhx"
        Map<String,List<Card>> players = new HashMap<>();
        List<Card> lhc = new ArrayList<>();
        players.put("玩家1",lhc);

        List<Card> lhj = new ArrayList<>();
        players.put("玩家2",lhj);

        List<Card> lhx = new ArrayList<>();
        players.put("玩家3",lhx);

//        allCards=[A♠, A♥, A♣, A♦, 2♠, 2♥, 2♣, 2♦, 3♠, 3♥, 3♣, 3♦, 4♠, 4♥, 4♣, ...]
//        只发出去5张牌：
        for (int i = 0; i < allCards.size() - 3; i++) {
//            获取到当前遍历的牌
            Card card = allCards.get(i);
//            判断当前这张牌发给谁
            if (i % 3 == 0) {
                lhc.add(card);
            } else if (i % 3 == 1) {
                lhj.add(card);
            } else if (i % 3 == 2) {
                lhx.add(card);
            }
        }



//     10,拿最后三张底牌
        List<Card> lastCards = allCards.subList(allCards.size() - 3,allCards.size());
        System.out.println("底牌是:" + lastCards);

//        抢地主：把这个集合直接到给玩家
        lhx.addAll(lastCards);

//     11，对牌排序
//     List<card> lhc = [9♠, 7♥, Q♠, 8♣, 8♠, A♠, 8♥, 9♥, A♦, 5♣, 10♣, J♦, 4♠, 6♥, 2♦, 8♦, A♥]
        sortCards(lhc);
        sortCards(lhj);
        sortCards(lhx);


//     12，看牌
        for (Map.Entry<String, List<Card>> entry : players.entrySet()) {
//            获取到玩家的名称
            String name = entry.getKey();
//            获取到玩家的牌
            List<Card> cards = entry.getValue();
//            遍历玩家牌
            System.out.println(name + ":" + cards);
        }
    }

    private void sortCards(List<Card> cards){
//        Collections.sort(cards, new Comparator<Card>() {
//            @Override
//            public int compare(Card o1, Card o2) {
//                return o2.getNum() - o1.getNum();
//            }
//        });

        Collections.sort(cards,(o1, o2) -> o2.getNum() - o1.getNum());
    }
}
