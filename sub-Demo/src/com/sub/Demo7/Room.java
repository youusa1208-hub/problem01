package com.sub.Demo7;

import java.util.*;

public class Room {
    //    1、54枚のカードを準備し、ルームで使用：54枚のカードを格納するコレクションコンテナを定義
    private List<Card> allCards = new ArrayList<>();
    //    2、54枚のカードを初期化して格納
    {
//    3、数値を準備
        String[] sizes = {"3","4","5","6","7","8","9","10","J","Q","K","2","A"};
//    String[] sizes = {"A","3","4","5","6","7","8","9","10","J","Q","K","2"};
//    4、スートを準備
        String[] colors = {"♠","♥","♣","♦"};
//    5、数値とスートを組み合わせてカードオブジェクトを作成し、コレクションに追加
        int num = 0;
        for (String size : sizes) {
            num++;
            for (String color : colors) {
//            6、カードオブジェクトを作成
                Card card = new Card(size,color, num);
//            7、コレクションに追加
                allCards.add(card);
            }
        }
//    allCards.add(new Card("","小王"));
//    allCards.add(new Card("","大王"));
        Collections.addAll(allCards,new Card("","小王",++num),new Card("","大王",++num));
        System.out.println("新しいカード:" + allCards);

    }

    public void start(){

//    8、シャッフル、コレクション内のカードをランダムに並び替え
        Collections.shuffle(allCards);
        System.out.println("シャッフル後:" + allCards);

//     9、配牌：3人のプレイヤーを定義："プレイヤー1"="lhc", "プレイヤー2"= "lhj", "プレイヤー3"= "lhx"
        Map<String,List<Card>> players = new HashMap<>();
        List<Card> lhc = new ArrayList<>();
        players.put("プレイヤー1",lhc);

        List<Card> lhj = new ArrayList<>();
        players.put("プレイヤー2",lhj);

        List<Card> lhx = new ArrayList<>();
        players.put("プレイヤー3",lhx);

//        allCards=[A♠, A♥, A♣, A♦, 2♠, 2♥, 2♣, 2♦, 3♠, 3♥, 3♣, 3♦, 4♠, 4♥, 4♣, ...]
//        最初の5枚のカードのみ配布：
        for (int i = 0; i < allCards.size() - 3; i++) {
//            現在処理中のカードを取得
            Card card = allCards.get(i);
//            現在のカードを誰に配るか判断
            if (i % 3 == 0) {
                lhc.add(card);
            } else if (i % 3 == 1) {
                lhj.add(card);
            } else if (i % 3 == 2) {
                lhx.add(card);
            }
        }



//     10、最後の3枚の底札を取得
        List<Card> lastCards = allCards.subList(allCards.size() - 3,allCards.size());
        System.out.println("底札:" + lastCards);

//        地主を争う：このコレクションを直接プレイヤーに渡す
        lhx.addAll(lastCards);

//     11、カードをソート
//     List<card> lhc = [9♠, 7♥, Q♠, 8♣, 8♠, A♠, 8♥, 9♥, A♦, 5♣, 10♣, J♦, 4♠, 6♥, 2♦, 8♦, A♥]
        sortCards(lhc);
        sortCards(lhj);
        sortCards(lhx);


//     12、カードを見る
        for (Map.Entry<String, List<Card>> entry : players.entrySet()) {
//            プレイヤー名を取得
            String name = entry.getKey();
//            プレイヤーのカードを取得
            List<Card> cards = entry.getValue();
//            プレイヤーのカードを走査
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
