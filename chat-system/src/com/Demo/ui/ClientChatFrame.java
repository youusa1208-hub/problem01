package com.Demo.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.List;

public class ClientChatFrame extends JFrame {
    public JTextArea smsContent = new JTextArea(23, 50);
    private JTextArea smsSend = new JTextArea(4, 40);
    public JList<String> onLineUsers = new JList<>();
    private JButton sendBn = new JButton("送信");
    private String nickname;
    private Socket socket;

    public ClientChatFrame() {
        initView();
        this.setVisible(true);
    }

    public ClientChatFrame(String nickname, Socket socket) {
        this();// 上の引数なしコンストラクタを呼び出して、インターフェース情報を初期化
//        データを初期化
//        ニックネームをウィンドウに即時表示
        this.setTitle(nickname + "のチャットウィンドウ");
        this.socket = socket;

//        クライアントのこのSocketパイプを独立スレッドに即時渡し、クライアントsocketがサーバーから受信したオンライン人数更新データまたはグループチャットデータの読み取りを専門的に担当
        new ClientReaderThread(socket,this).start();
    }

    private void initView() {
        this.setSize(700, 600);
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ウィンドウを閉じてプログラムを終了
        this.setLocationRelativeTo(null); // ウィンドウを中央に配置

        // ウィンドウの背景色を設定
        this.getContentPane().setBackground(new Color(0xf0, 0xf0, 0xf0));

        // フォントを設定
        Font font = new Font("SimKai", Font.PLAIN, 14);

        // メッセージ内容ボックス
        smsContent.setFont(font);
        smsContent.setBackground(new Color(0xdd, 0xdd, 0xdd));
        smsContent.setEditable(false);

        // メッセージ送信ボックス
        smsSend.setFont(font);
        smsSend.setWrapStyleWord(true);
        smsSend.setLineWrap(true);

        // オンラインユーザーリスト
        onLineUsers.setFont(font);
        onLineUsers.setFixedCellWidth(120);
        onLineUsers.setVisibleRowCount(13);

        // 下部パネルを作成
        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.setBackground(new Color(0xf0, 0xf0, 0xf0));

        // メッセージ入力ボックス
        JScrollPane smsSendScrollPane = new JScrollPane(smsSend);
        smsSendScrollPane.setBorder(BorderFactory.createEmptyBorder());
        smsSendScrollPane.setPreferredSize(new Dimension(500, 50));

        // 送信ボタン
        sendBn.setFont(font);
        sendBn.setBackground(Color.decode("#009688"));
        sendBn.setForeground(Color.WHITE);

        // ボタンパネル
        JPanel btns = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 5));
        btns.setBackground(new Color(0xf0, 0xf0, 0xf0));
        btns.add(sendBn);

        // 送信ボタンにクリックイベントをバインド
        sendBn.addActionListener(e -> {
            // 入力ボックスの内容を取得
            String msg = smsSend.getText();
            // 入力ボックスをクリア
            smsSend.setText("");
            // メッセージを送信
            sendMsgToServer(msg);
        });

        // コンポーネントを追加
        bottomPanel.add(smsSendScrollPane, BorderLayout.CENTER);
        bottomPanel.add(btns, BorderLayout.EAST);

        // ユーザーリストパネル
        JScrollPane userListScrollPane = new JScrollPane(onLineUsers);
        userListScrollPane.setBorder(BorderFactory.createEmptyBorder());
        userListScrollPane.setPreferredSize(new Dimension(120, 500));

        // 中央メッセージパネル
        JScrollPane smsContentScrollPane = new JScrollPane(smsContent);
        smsContentScrollPane.setBorder(BorderFactory.createEmptyBorder());

        // すべてのコンポーネントを追加
        this.add(smsContentScrollPane, BorderLayout.CENTER);
        this.add(bottomPanel, BorderLayout.SOUTH);
        this.add(userListScrollPane, BorderLayout.EAST);
    }

    //    メッセージを送信
    private void sendMsgToServer(String msg) {
//        1, socketパイプから特殊なデータ出力ストリームを取得
        try {
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
//        2, メッセージをサーバーに送信
            dos.writeInt(2);
            dos.writeUTF(msg);
            dos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new ClientChatFrame();
    }

    public void updateOnLineUserList(String[] onLineNames) {
//        このスレッドが読み取ったオンラインユーザー名をインターフェースに表示
        onLineUsers.setListData(onLineNames);
    }

    //    グループチャットメッセージを更新
    public void setMsgToWin(String msg) {
//        グループチャットメッセージをインターフェースに更新して表示
        smsContent.append(msg);
    }
}
