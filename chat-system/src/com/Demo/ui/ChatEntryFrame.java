package com.Demo.ui;

import javax.swing.*;
import java.awt.*;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ChatEntryFrame extends JFrame {

    private JTextField nicknameField;
    private JButton enterButton;
    private JButton cancelButton;
    private Socket socket;// 現在のクライアントシステムの通信パイプを記録

    public ChatEntryFrame() {
        setTitle("ローカルチャット");
        setSize(350, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false); // サイズ変更を禁止

        // 背景色を設定
        getContentPane().setBackground(Color.decode("#F0F0F0"));

        // メインパネルを作成し、レイアウトを設定
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(Color.decode("#F0F0F0"));
        add(mainPanel);

        // トップパネルを作成
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        topPanel.setBackground(Color.decode("#F0F0F0"));

        // ラベルとテキストフィールド
        JLabel nicknameLabel = new JLabel("ニックネーム:");
        nicknameLabel.setFont(new Font("楷体", Font.BOLD, 16));
        nicknameField = new JTextField(10);
        nicknameField.setFont(new Font("楷体", Font.PLAIN, 16));
        nicknameField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)
        ));

        topPanel.add(nicknameLabel);
        topPanel.add(nicknameField);
        mainPanel.add(topPanel, BorderLayout.NORTH);

        // ボタンパネル
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        buttonPanel.setBackground(Color.decode("#F0F0F0"));

        enterButton = new JButton("ログイン");
        enterButton.setFont(new Font("楷体", Font.BOLD, 16));
        enterButton.setBackground(Color.decode("#007BFF"));
        enterButton.setForeground(Color.WHITE);
        enterButton.setBorderPainted(false);
        enterButton.setFocusPainted(false);

        cancelButton = new JButton("キャンセル");
        cancelButton.setFont(new Font("楷体", Font.BOLD, 16));
        cancelButton.setBackground(Color.decode("#DC3545"));
        cancelButton.setForeground(Color.WHITE);
        cancelButton.setBorderPainted(false);
        cancelButton.setFocusPainted(false);

        buttonPanel.add(enterButton);
        buttonPanel.add(cancelButton);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        // リスナーを追加
        enterButton.addActionListener(e -> {
            String nickname = nicknameField.getText();// ニックネームを取得
            nicknameField.setText("");
            if (!nickname.isEmpty()) {
                // チャットルームに入るロジック
                // サーバープログラムにログインメッセージを即時送信
                try {
                    login(nickname);
                    // チャットルームに入るロジック：チャットインターフェースを起動し、ニックネームをチャットインターフェースに渡す
                    new ClientChatFrame(nickname,socket);
                    this.dispose();// ログインウィンドウを閉じる
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

                dispose(); // ウィンドウを閉じる
            } else {
                JOptionPane.showMessageDialog(this, "ニックネームを入力してください!");
            }
        });

        cancelButton.addActionListener(e -> System.exit(0));

        this.setVisible(true);
    }

    private void login(String nickname) throws Exception {
        // サーバープログラムにログインメッセージを即時送信
        // 1. サーバーのソケットとの接続を要求するソケットパイプを作成
        socket = new Socket(Constant.SERVER_IP, Constant.SERVER_PORT);
        // 2. メッセージタイプ1と自分のニックネームをサーバーに即時送信
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        dos.writeInt(1);// メッセージタイプ、ログイン
        dos.writeUTF(nickname);
        dos.flush();
    }

    public static void main(String[] args) {
        new ChatEntryFrame();
    }
}