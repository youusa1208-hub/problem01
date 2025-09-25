package com.sub.Demo6;

public class Test {
    public static void main(String[] args) {
//     目標：映画ケースを完成する
//        1、映画オブジェクトを作成：映画クラスを定義
//        2、映画操作オブジェクトを作成：映画データの業務処理（掲載、削除、検索、問題のある映画の封殺）を専門的に担当

        MovieService movieService = new MovieService();
        movieService.start();
    }
}
