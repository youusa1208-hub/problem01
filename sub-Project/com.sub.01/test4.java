public class test4 {
//    public static void main(String[] args) {
//        // 101から200までの素数の個数を数えて表示
//        int count = count(200);
//        System.out.println("\n101から200までの素数の個数は: " + count);
//    }
//
//    /**
//     * 101から200までの素数をカウントし、すべて出力する
//     * @param n 上限値（ここでは200）
//     * @return 素数の個数
//     */
//    public static int count(int n){
//        int count = 0; // 素数の個数をカウントする変数
//        for (int i = 101; i <= 200; i++) {
//            boolean isPrime = true; // 素数かどうかのフラグ
//            // iが素数かどうかを判定
//            for (int j = 2; j <= Math.sqrt(i); j++) {
//                if (i % j == 0) {
//                    isPrime = false; // 割り切れる場合は素数ではない
//                    break;
//                }
//            }
//            if (isPrime) {
//                System.out.print(i + " "); // 素数を出力
//                count++; // 素数の個数を増やす
//            }
//        }
//        return count; // 素数の個数を返す
//    }
//}

    public static void main(String[] args) {
        int count = 0;
    // 101から200までの数を順に調べる
    for (int i = 101; i <= 200; i++) {
        if (isPrime(i)) { // 素数の場合
            System.out.print(i + " "); // 素数を出力
            count++;
        }
    }
    System.out.println("\n101から200までの素数の個数は: " + count + "個です");
}

// 指定された数が素数かどうかを判定するメソッド
public static boolean isPrime(int num) {
    if (num < 2) return false; // 2未満は素数ではない
    for (int i = 2; i <= Math.sqrt(num); i++) { // 2から√numまで調べる
        if (num % i == 0) {
            return false; // 割り切れる場合は素数ではない
        }
    }
    return true; // 素数
}

}


/*
どちらの方法も、101から200の素数を出力して数を数えるという同じ機能を実現しています。

最初の書き方は、素数の判定・出力・カウントを1つのメソッドにまとめており、コンパクトですが結合度が高く、可読性はやや劣ります。

2番目の書き方は、素数かどうかの判定を isPrime() メソッドに分離しており、構造が明確で再利用や保守がしやすいです。

コードの見やすさや保守性を重視するなら、2番目の方法をおすすめします

 */