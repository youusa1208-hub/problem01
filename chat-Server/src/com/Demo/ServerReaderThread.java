package com.Demo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;

public class ServerReaderThread extends Thread {
    private Socket socket;
    public ServerReaderThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
//          受信するメッセージには多くのタイプがある可能性があります：1、ログインメッセージ（ニックネームを含む）、2、グループチャットメッセージ、3、プライベートチャットメッセージ
//          そのため、クライアントはプロトコルを宣言してメッセージを送信する必要があります
//            例えば、クライアントが最初に1を送信すると、次に来るメッセージはログインメッセージを意味します
//            例えば、クライアントが最初に2を送信すると、次に来るメッセージはグループチャットメッセージを意味します
//            最初にsocketパイプからクライアントが送信したメッセージタイプ番号を受け取ります
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            while (true) {
                int type = dis.readInt();//1,2,3
                switch (type) {
                    case 1:
                        // クライアントからログインメッセージが送信されました。次にニックネームデータを受け取り、すべてのオンラインクライアントのオンライン人数リストを更新します
                        String nickname = dis.readUTF();
                        // ログイン成功したクライアントsocketをオンラインコレクションに格納
                        Server.onLineSockets.put(socket, nickname);
                        // すべてのクライアントのオンライン人数リストを更新
                        upDateClientOnLineUserList();
                        break;
                    case 2:
                        // クライアントからグループチャットメッセージが送信されました。次にグループチャットメッセージデータを受け取り、すべてのオンラインクライアントにグループチャットメッセージを送信します
                        String msg = dis.readUTF();
                        sendMsgToALL(msg);
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println("クライアント接続切断：" + socket.getInetAddress().getHostAddress());
            Server.onLineSockets.remove(socket);// オフラインになったクライアントsocketをオンラインコレクションから削除
            upDateClientOnLineUserList();// ユーザーがオフラインになってもすべてのクライアントのオンライン人数リストを更新する必要があります
        }
    }

    //    すべてのオンラインsocketに現在のクライアントから送信されたメッセージをプッシュ
    private void sendMsgToALL(String msg) {
//        このメッセージを正しく組み立ててから、すべてのオンラインsocketに送信する必要があります
        StringBuilder sb = new StringBuilder();
        String name = Server.onLineSockets.get(socket);

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss EEE");
        String nowStr = now.format(dtf);

        String msgResult = sb.append(name).append(" ").append(nowStr)
                .append("\r\n").append(msg).append("\r\n").toString();
//        すべてのクライアントsocketにプッシュ
        for (Socket socket : Server.onLineSockets.keySet()) {
            try {
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                dos.writeInt(2);//1はクライアントに次にオンライン人数リストメッセージであることを伝え、2はグループチャットメッセージ、3はプライベートチャットメッセージを表します
                dos.writeUTF(msgResult);
                dos.flush();//データをフラッシュ！
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private void upDateClientOnLineUserList() {
//        すべてのクライアントのオンライン人数リストを更新
//        すべてのオンラインクライアントのユーザー名を取得し、これらの名前をすべてのオンラインsocketパイプに転送します。
//        1、現在のすべてのオンラインユーザーのニックネームを取得
        Collection<String> onLineUsers = Server.onLineSockets.values();
//        2、このコレクションのすべてのユーザーをすべてのクライアントsocketパイプにプッシュします。
        for (Socket socket : Server.onLineSockets.keySet()) {
            try {
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                dos.writeInt(1);//1はクライアントに次にオンライン人数リストメッセージであることを伝え、2はグループチャットメッセージ、3はプライベートチャットメッセージを表します
                dos.writeInt(onLineUsers.size());//クライアントにこのコレクションに何人のユーザー名があるかを伝えます
                for (String user : onLineUsers) {
                    dos.writeUTF(user);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
