package com.Demo.Demo8Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MovieService {
//    4,准备一个集合容器:存储全部上架的电影数据.

    private static List<Movie> movies = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);
    public void start() {
//        3,准备操作界面:GUI界面/cmd命令做
        while (true) {
            System.out.println("====电影信息操作系统=====");
            System.out.println("1.添加电影");
            System.out.println("2.删除电影");
            System.out.println("3.查询电影");
            System.out.println("4.封杀某个明星");
            System.out.println("5.退出系统");
            System.out.println("6.显示所有电影");
            System.out.println("7.修改某个电影");
            System.out.println("请您输入操作命名:");
            String option = sc.next();
            switch (option) {
                case "1":
                //上架(独立功能独立成方法)
                    addMovie();
                    break;
                case "2":
                    deleteMovie();
                    break;
                case "3":
//                    查询 电影
                    queryMovie();
                    break;
                case "4":
//                    封杀某个明显
                    deleteStar();
                    break;
                case "5":
                    System.out.println("退出成功");
                    return;
                case "6":
                    queryAllMovie();
                    return;
                case "7":
//                    修改某个电影
                    updateMovie();
                    return;
                default:
                    System.out.println("输入错误，请重新输入");
                    start();
            }
        }
    }

    private void updateMovie() {
        System.out.println("修改电影");
        System.out.println("请输入电影名称:");
        String name = sc.next();
        for (Movie movie : movies) {
            if (movie.getName().equals(name)) {
                System.out.println("请输入电影名称:");
                movie.setName(sc.next());
                System.out.println("请输入电影主演:");
                movie.setActor(sc.next());
                System.out.println("请输入电影价格:");
                movie.setPrice(sc.nextDouble());
                System.out.println("请输入电影评分:");
            }
        }
        System.out.println("修改成功");
        queryAllMovie();
    }

    private void queryAllMovie() {
        System.out.println("显示所有电影");
        for (Movie movie : movies) {
            System.out.println(movie.getName()+" " + movie.getActor()+" " + movie.getPrice()+" " + movie.getScore());
        }
    }

    /**
     * 封杀某个明星
     */
    private void deleteStar() {
        System.out.println("封杀某个明星");
        System.out.println("请输入要封杀的明星名称:");
        String starName = sc.next();
        for (int i = 0; i < movies.size(); i++) {
            Movie movie = movies.get(i);
            if (movie.getActor().contains(starName)) {
                movies.remove(movie);
                System.out.println("封杀成功");
                i--;//退一步
            }
        }
//        展示全部电影
        queryAllMovie();
    }

    /**
     * 根据电影名称查询某部电影对象展示出来
     */
    private void queryMovie() {
        System.out.println("查询电影");
        System.out.println("请输入电影名称:");
        String name = sc.next();
//        根据电影名称查询电影对象返回,展示这个对象数据.
        Movie movie = queryMovieByName(name);
        if (movie != null) {
            System.out.println(movie);
        }else {
            System.out.println("没有找到该电影");
        }
    }

//    根据电影名称查询电影对象返回
//    movies = [m1,m2,m3,.....]
    private Movie queryMovieByName(String name) {
        for (Movie movie : movies) {
            if (movie.getName().equals(name)) {
                return movie;// 找到电影对象
            }
        }
        return null;// 没有找到电影对象
    }

    private void deleteMovie() {
        System.out.println("删除电影");
        System.out.println("请输入电影名称:");
        String name = sc.next();
        for (Movie movie : movies) {
            if (movie.getName().equals(name)) {
                movies.remove(movie);
                System.out.println("删除成功");
                return;
            }
        }
        System.out.println("没有找到该电影");
        queryAllMovie();
    }


    /**
     * 添加电影
     */
    private void addMovie() {
        System.out.println("上架电影");
//        分析:每点击一次上架电影,其实就是新增一部电影,每部电影是一个电影对象封装数据的.
//        1,创建电影对象.封装这个电影信息.
        Movie movie = new Movie();
//        2,给电影对象注入数据.
        System.out.println("请输入电影名称:");
        movie.setName(sc.next());
        System.out.println("请输入电影主演:");
        movie.setActor(sc.next());
        System.out.println("请输入电影价格:");
        movie.setPrice(sc.nextDouble());
        System.out.println("请输入电影评分:");
        movie.setScore(sc.nextDouble());

//        3,把电影对象添加到集合中.
        movies.add(movie);
        System.out.println("上架成功");

    }


}
