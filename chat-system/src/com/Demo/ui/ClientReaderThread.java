package com.Demo.ui;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ClientReaderThread extends Thread {
    private Socket socket;
    private DataInputStream dis;
    private ClientChatFrame win;

    public ClientReaderThread(Socket socket, ClientChatFrame win) {
        this.win = win;
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
//          受信するメッセージには多くのタイプがある可能性があります：1、ログインメッセージ（ニックネームを含む）、2、グループチャットメッセージ
//          そのため、クライアントはプロトコルを宣言してメッセージを送信する必要があります
//            例えば、クライアントが最初に1を送信すると、次に来るメッセージはログインメッセージを意味します
//            例えば、クライアントが最初に2を送信すると、次に来るメッセージはグループチャットメッセージを意味します
//            最初にsocketパイプからクライアントが送信したメッセージタイプ番号を受け取ります
            dis = new DataInputStream(socket.getInputStream());
            while (true) {
                int type = dis.readInt();//1,2,3
                switch (type) {
                    case 1:
                        // サーバーから送信されたオンライン人数更新メッセージ
                        upDateClientOnLineUserList();
                        break;
                    case 2:
                        // サーバーから送信されたグループチャットメッセージ
                        getMsgToWin();
                        break;

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void getMsgToWin() throws Exception {
//        グループチャットメッセージを取得
        String msg = dis.readUTF();
        win.setMsgToWin(msg);
    }

    //    クライアントのオンラインユーザーリストを更新
    private void upDateClientOnLineUserList() throws Exception {
//        1、オンラインユーザー数を読み取り
        int count = dis.readInt();

//        2、ループでユーザー情報をいくつ読み取るかを制御
        String[] names = new String[count];
        for (int i = 0; i < count; i++) {
//            3、各ユーザーの情報を読み取り
            String nickName = dis.readUTF();
//            4、各ユーザーの情報をコレクションに追加
            names[i] = nickName;
        }
//        5、コレクションのデータをウィンドウに表示
        win.updateOnLineUserList(names);
    }

}
