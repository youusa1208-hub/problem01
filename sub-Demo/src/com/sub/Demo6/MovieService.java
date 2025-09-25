package com.sub.Demo6;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MovieService {
//    4、集合コンテナを準備：すべての掲載済み映画データを格納

    private static List<Movie> movies = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);
    public void start() {
//        3、操作インターフェースを準備：GUIインターフェース/cmdコマンドで実装
        while (true) {
            System.out.println("====映画情報管理システム=====");
            System.out.println("1.映画追加");
            System.out.println("2.映画削除");
            System.out.println("3.映画検索");
            System.out.println("4.特定俳優の封殺");
            System.out.println("5.システム終了");
            System.out.println("6.すべての映画を表示");
            System.out.println("7.映画情報の修正");
            System.out.println("操作コマンドを入力してください:");
            String option = sc.next();
            switch (option) {
                case "1":
                    //掲載（独立機能は独立メソッドに）
                    addMovie();
                    break;
                case "2":
                    deleteMovie();
                    break;
                case "3":
//                    映画検索
                    queryMovie();
                    break;
                case "4":
//                    特定俳優の封殺
                    deleteStar();
                    break;
                case "5":
                    System.out.println("正常終了");
                    return;
                case "6":
                    queryAllMovie();
                    return;
                case "7":
//                    映画情報の修正
                    updateMovie();
                    return;
                default:
                    System.out.println("入力エラー、再入力してください");
                    start();
            }
        }
    }

    private void updateMovie() {
        System.out.println("映画情報の修正");
        System.out.println("映画名を入力してください:");
        String name = sc.next();
        for (Movie movie : movies) {
            if (movie.getName().equals(name)) {
                System.out.println("映画名を入力してください:");
                movie.setName(sc.next());
                System.out.println("主演俳優を入力してください:");
                movie.setActor(sc.next());
                System.out.println("価格を入力してください:");
                movie.setPrice(sc.nextDouble());
                System.out.println("評価を入力してください:");
            }
        }
        System.out.println("修正成功");
        queryAllMovie();
    }

    private void queryAllMovie() {
        System.out.println("すべての映画を表示");
        for (Movie movie : movies) {
            System.out.println(movie.getName()+" " + movie.getActor()+" " + movie.getPrice()+" " + movie.getScore());
        }
    }

    /**
     * 特定俳優の封殺
     */
    private void deleteStar() {
        System.out.println("特定俳優の封殺");
        System.out.println("封殺する俳優名を入力してください:");
        String starName = sc.next();
        for (int i = 0; i < movies.size(); i++) {
            Movie movie = movies.get(i);
            if (movie.getActor().contains(starName)) {
                movies.remove(movie);
                System.out.println("封殺成功");
                i--;//1ステップ戻る
            }
        }
//        すべての映画を表示
        queryAllMovie();
    }

    /**
     * 映画名で特定の映画オブジェクトを検索して表示
     */
    private void queryMovie() {
        System.out.println("映画検索");
        System.out.println("映画名を入力してください:");
        String name = sc.next();
//        映画名で映画オブジェクトを検索して返却、そのオブジェクトデータを表示
        Movie movie = queryMovieByName(name);
        if (movie != null) {
            System.out.println(movie);
        }else {
            System.out.println("該当映画が見つかりません");
        }
    }

    //    映画名で映画オブジェクトを検索して返却
//    movies = [m1,m2,m3,.....]
    private Movie queryMovieByName(String name) {
        for (Movie movie : movies) {
            if (movie.getName().equals(name)) {
                return movie;// 映画オブジェクトが見つかる
            }
        }
        return null;// 映画オブジェクトが見つからない
    }

    private void deleteMovie() {
        System.out.println("映画削除");
        System.out.println("映画名を入力してください:");
        String name = sc.next();
        for (Movie movie : movies) {
            if (movie.getName().equals(name)) {
                movies.remove(movie);
                System.out.println("削除成功");
                return;
            }
        }
        System.out.println("該当映画が見つかりません");
        queryAllMovie();
    }


    /**
     * 映画追加
     */
    private void addMovie() {
        System.out.println("映画掲載");
//        分析：映画掲載を1回クリックするたびに、新しい映画が追加される。各映画は映画オブジェクトでデータをカプセル化
//        1、映画オブジェクトを作成し、映画情報をカプセル化
        Movie movie = new Movie();
//        2、映画オブジェクトにデータを注入
        System.out.println("映画名を入力してください:");
        movie.setName(sc.next());
        System.out.println("主演俳優を入力してください:");
        movie.setActor(sc.next());
        System.out.println("価格を入力してください:");
        movie.setPrice(sc.nextDouble());
        System.out.println("評価を入力してください:");
        movie.setScore(sc.nextDouble());

//        3、映画オブジェクトを集合に追加
        movies.add(movie);
        System.out.println("掲載成功");

    }


}
