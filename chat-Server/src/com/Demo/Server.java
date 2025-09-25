package com.Demo;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class Server {
    //    ログインしてきたすべてのクライアントパイプを格納するコレクションコンテナを定義し、将来それらにメッセージを一斉送信できるようにする。
//    Mapコレクションを定義し、キーはクライアントのパイプを格納し、値はこのパイプのユーザー名とする。
    public static final Map<Socket, String> onLineSockets = new HashMap<>();
    public static void main(String[] args) {
        System.out.println("サーバーシステムを起動中..");
//        1、ポートを登録。
        try {
            ServerSocket serverSocket = new ServerSocket(Constant.PORT);
//            2、メインスレッドがクライアントの接続要求を処理
            while (true) {
//                3、acceptメソッドを呼び出してSocketオブジェクトを取得
                System.out.println("クライアントの接続を待機中...");

                Socket socket = serverSocket.accept();
//                このパイプを独立したスレッドに渡して処理：多数のクライアントが同時に通信できるようにサポート
                new ServerReaderThread(socket).start();

                System.out.println("クライアント接続成功...");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
