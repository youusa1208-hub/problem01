package com.Demo.Demo8Test;

public class Test {
    public static void main(String[] args) {
//     目标:完成电影案例
//        1,创建电影对象:定义电影类
//        2,创建一个电影操作对象:专门负责对象电影数据进行业务处理(上架,下架,查询,封杀某个明显的电影)

        MovieService movieService = new MovieService();
        movieService.start();
    }
}
