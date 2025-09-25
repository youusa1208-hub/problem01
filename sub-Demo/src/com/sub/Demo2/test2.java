package com.sub.Demo2;

public class test2 {
    public static void main(String[] args) {

        start(7);
    }

    public static void start(int n){
        // n×nの二次元配列を初期化
        int[][]arr = new int[n][n];

        // 配列に格納する数値のカウンターを初期化
        int count = 1;

        // 二次元配列に1から順番に数値を格納する
        for (int i = 0; i < arr.length ; i++) {      // 外側のループ：行を処理
            for (int j = 0; j <arr[i].length ; j++) { // 内側のループ：列を処理
                arr[i][j] = count++;  // 現在のcount値を配列に格納し、カウントを1増加
            }
        }
        // 配列の内容を表示
        printArray(arr);

        System.out.println("---------");

        // 配列の要素をランダムに入れ替えてシャッフルする
        for (int i = 0; i < arr.length ; i++) {      // 外側のループ：行を処理
            for (int j = 0; j < arr[i].length; j++) { // 内側のループ：列を処理
                // ランダムな位置を2つ生成
                int k = (int) (Math.random()*arr.length);  // 0から(n-1)までのランダムな行インデックス
                int l = (int) (Math.random()*arr.length);  // 0から(n-1)までのランダムな列インデックス

                // 2つの要素を入れ替える（シャッフル処理）
                int temp = arr[k][l];      // 一時変数にランダム位置の要素を保存
                arr[k][l] = arr[i][j];     // ランダム位置に現在位置の要素を格納
                arr[i][j] = temp;          // 現在位置に一時変数の要素を格納（入れ替え完了）
            }
        }

        // シャッフル後の配列の内容を表示
        printArray(arr);
    }

    // 二次元配列を整形して表示するメソッド
    public static void printArray(int[][] arr){
        for (int i = 0; i < arr.length ; i++) {      // 外側のループ：行を処理
            for (int j = 0; j <arr[i].length ; j++) { // 内側のループ：列を処理
                System.out.print(arr[i][j]+"\t");     // 各要素をタブ区切りで表示
            }
            System.out.println();  // 各行の表示が終わったら改行
        }
    }
}
