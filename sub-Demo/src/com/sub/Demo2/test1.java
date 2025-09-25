package com.sub.Demo2;

public class test1 {
    public static void main(String[] args) {

        start();
    }

    public static void start() {
        // トランプカードを格納する配列を初期化（54枚：52枚の通常カード + 2枚のジョーカー）
        String [] poker = new String[54];
        // poker = [null,null,null,null,null,null,....] // 初期値はnull

        // トランプのマーク（スート）を定義
        String [] colors = {"♠","♥","♣","♦"};  // スペード、ハート、クラブ、ダイヤ
        // トランプの数字を定義（A,2-10,J,Q,K）
        String [] numbers = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};

        // 配列のインデックスを管理する変数
        int index = 0;

        // 数字のループ（13回：AからKまで）
        for (int i = 0; i < numbers.length; i++) {
            // マークのループ（4回：スペードからダイヤまで）
            for (int j = 0; j < colors.length; j++) {
                // マークと数字を結合して1枚のカードを作成し、配列に格納
                // index++ により、格納後インデックスが1増加
                poker[index++] = colors[j] + numbers[i];
            }

        }

        // ループの最後にジョーカーを追加
        poker[index++] = "小鬼";    // 小ジョーカー
        poker[index] = "大鬼";  // 大ジョーカー

        // 出力の区切り（全角セミコロン）
        System.out.print("シャッフル前：");

        // すべてのトランプカードを表示
        for (int i = 0; i < poker.length; i++) {
            System.out.print(poker[i]+"\t");  // 各カードの間にスペースを挿入して表示
        }

        // 改行処理
        System.out.println();//

        for (int i = 0; i < poker.length; i++) {
            // ランダムなインデックス1を生成（0から53までの整数）
            int index1 = (int)(Math.random() * poker.length);
            // ランダムなインデックス2を生成（0から53までの整数）
            int index2 = (int)(Math.random() * poker.length);
            // 2枚のカードを入れ替えるための一時変数
            String temp = poker[index1];
            // インデックス1のカードをインデックス2のカードで上書き
            poker[index1] = poker[index2];
            // インデックス2のカードを一時変数のカードで上書き（入れ替え完了）
            poker[index2] = temp;

        }

        System.out.print("シャッフル後：");

        for (int i = 0; i < poker.length; i++) {
            System.out.print(poker[i]+"\t");  // 各カードの間にスペースを挿入して表示
        }

    }
}
