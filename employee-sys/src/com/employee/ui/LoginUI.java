package com.employee.ui;

import com.employee.bean.User;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


// カスタムログイン画面
public class LoginUI extends JFrame implements ActionListener {
    private JTextField loginNameField; // ユーザー名入力欄
    private JPasswordField passwordField; // パスワード入力欄
    private JButton loginButton; // ログインボタン
    private JButton registerButton; // 登録ボタン
    // 静的コレクションを定義し、システム内のすべてのユーザーオブジェクト情報を格納
    private static ArrayList<User> allUsers = new ArrayList<>();

    // テスト用のユーザーオブジェクト情報をいくつか初期化し、ログイン用とする
static {
        allUsers.add(new User("admin", "123456", "admin"));
        allUsers.add(new User("user", "123456", "user"));
        allUsers.add(new User("test", "123456", "test"));
        allUsers.add(new User("admin1", "123456", "admin1"));
        allUsers.add(new User("user1", "123456", "user1"));
}

    public LoginUI(){
        super("ログイン画面");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 400);
        this.setLocationRelativeTo(null); // 中央表示

        createAndShowGUI();
    }

    private void createAndShowGUI() {
        // メインウィンドウの作成
        // パネルの作成
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(240, 240, 240));

        // フォントと色の設定
        Font customFont = new Font("楷体", Font.BOLD, 18);
        Color primaryColor = new Color(66, 135, 245);
        Color secondaryColor = new Color(204, 204, 204); // 登録ボタン用のより薄い色

        // タイトル
        JLabel titleLabel = new JLabel("人事情報管理システム");
        titleLabel.setBounds(50, 30, 300, 30);
        titleLabel.setFont(new Font("楷体", Font.BOLD, 24));
        panel.add(titleLabel);

        // ユーザー名ラベル
        JLabel usernameLabel = new JLabel("ユーザー名：");
        usernameLabel.setBounds(50, 100, 150, 30);
        usernameLabel.setFont(customFont);
        panel.add(usernameLabel);

        // ユーザー名入力欄
        loginNameField = new JTextField();
        loginNameField.setBounds(160, 100, 190, 30);
        loginNameField.setFont(customFont);
        panel.add(loginNameField);

        // パスワードラベル
        JLabel passwordLabel = new JLabel("パスワード：");
        passwordLabel.setBounds(50, 150, 150, 30);
        passwordLabel.setFont(customFont);
        panel.add(passwordLabel);

        // パスワード入力欄
        passwordField = new JPasswordField();
        passwordField.setBounds(160, 150, 190, 30);
        passwordField.setFont(customFont);
        // マスク文字をアスタリスクに設定し、すべてのフォントで正しく表示されるようにする
        passwordField.setEchoChar('*');
        panel.add(passwordField);


        // ログインボタン
        loginButton = new JButton("ログイン");
        loginButton.setBounds(50, 200, 150, 30);
        loginButton.setFont(customFont);
        loginButton.setBackground(primaryColor);
        loginButton.setForeground(Color.WHITE);
        panel.add(loginButton);
        loginButton.addActionListener(this);


        // 登録ボタン
        registerButton = new JButton("登録");
        registerButton.setBounds(200, 200, 150, 30);
        registerButton.setFont(customFont);
        registerButton.setBackground(secondaryColor);
        registerButton.setForeground(Color.BLACK);
        panel.add(registerButton);
        registerButton.addActionListener(this);

        // パネルをウィンドウに追加
        this.add(panel);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // ここではログインボタンがクリックされた可能性もあるし、登録ボタンがクリックされた可能性もある
        // ログインボタンと登録ボタンのどちらがクリックされたかを判断
        JButton btn = (JButton) e.getSource();
        if (btn == loginButton) {
            // 独立機能は独立したメソッドにする
            login();
        }else {
            System.out.println("登録からのアクセス");
        }
    }

    private void login() {
        // 1、ユーザーが入力したユーザー名とパスワードを取得
        String loginName = loginNameField.getText();
        String password = new String(passwordField.getPassword());
        // 2、コレクションを走査し、ユーザーが入力したユーザー名とパスワードがコレクション内のオブジェクトと一致するかを判断。一致すればログイン成功
        // 3、ログイン名でユーザーオブジェクトを検索して返す。ユーザーオブジェクトが検索できれば、ログイン名が正しいことを意味する
        User user = getUserByLoginName(loginName);
        if (user != null) {
            // 4、パスワードが正しいかを判断
            if (user.getPassword().equals(password)) {
                // ログイン成功
                System.out.println("ログイン成功！");
                // 従業員管理画面に遷移
                new EmployeeManagerUI(user.getUsername());
                this.dispose(); // 現在のログイン画面を閉じる
            }else {
                // パスワードエラー
                JOptionPane.showMessageDialog(this, "パスワードエラー！");
            }
        }else {
            JOptionPane.showMessageDialog(this, "ログイン名が存在しません！");
        }
    }

    // ログイン名でユーザーオブジェクトを検索して返す。ユーザーオブジェクトが検索できれば、ログイン名が正しいことを意味する。forループを使ってインデックスで走査
    private User getUserByLoginName(String loginName) {
        for (int i = 0; i < allUsers.size(); i++) {
            User user = allUsers.get(i);
            if (user.getLoginname().equals(loginName)) {
                return user;
            }
        }
        return null; // ユーザーオブジェクトが検索できなかった場合、ログイン名が正しくないことを意味する
    }
}
