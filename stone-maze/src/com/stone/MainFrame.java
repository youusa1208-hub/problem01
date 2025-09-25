package com.stone;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.*;

//自動表示ウィンドウクラス。オブジェクトを作成してメインウィンドウを表示する
public class MainFrame extends JFrame {
    //    画像のパスを設定
    private static final String imagePath = "stone-maze/src/image/";
    //    数字ブロックの行と列の位置を保存する配列：4行4列
    private int[][] imageData = {
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12},
            {13,14,15,0}
    };

    private int[][] winData = {
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12},
            {13,14,15,0}
    };

    //    現在の空白ブロックの位置を記録する2つの整数変数
    private int row;//行インデックス
    private int col;//列インデックス
    private int count;//移動ステップ数を統計
    private int minCount;//履歴最小ステップ数

    public MainFrame(){

        minCount = readFileScore();
        System.out.println("履歴最小ステップ数：" + minCount);
//        1，初期化メソッドを呼び出す：ウィンドウのサイズなどの情報を初期化
        initFrame();
//        4,配列ブロックの順序をランダム化し、画像を表示
        initRandomArray();
//        2，インターフェースを初期化：数字ブロックを表示
        initImage();
//        3,システムメニューを初期化：クリックでメニュー情報を表示（システム終了かゲーム再開か）
        initMenu();
//        5,現在のウィンドウにキーボードリスナーを追加し、キーボード押下イベントを監視
        initKeyPressEvent();
//            ウィンドウの表示を設定
        this.setVisible(true);

    }

    private void initKeyPressEvent() {
//        現在のウィンドウに上下左右ボタンのイベントをバインド
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
//                現在のキーの番号を取得
                int keyCode = e.getKeyCode();
//                この番号が上下左右キーかどうかを判定
                switch (keyCode) {
                    case KeyEvent.VK_UP:
//                        上キーがクリックされた。画像を上に移動
                        switchAndMove(Direction.UP);
                        break;
                    case KeyEvent.VK_DOWN:
//                        下キーがクリックされた。画像を下に移動
                        switchAndMove(Direction.DOWN);
                        break;
                    case KeyEvent.VK_LEFT:
//                        左キーがクリックされた。画像を左に移動
                        switchAndMove(Direction.LEFT);
                        break;
                    case KeyEvent.VK_RIGHT:
//                        右キーがクリックされた。画像を右に移動
                        switchAndMove(Direction.RIGHT);
                        break;
                }
            }
        });
    }


    //   データ交換と画像移動を制御
    private void switchAndMove(Direction direction) {
//        画像の方向を判定し、画像移動を制御
        switch (direction) {
            case UP:
//                上に交換する条件は行が3未満であること
                if (row< imageData.length - 1) {
//                    現在の空白ブロックの位置：row, col
//                    交換される位置: row + 1, col
                    int temp = imageData[row][col];
                    imageData[row][col] = imageData[row + 1][col];
                    imageData[row + 1][col] = temp;
//                    現在の空白ブロックの位置を更新
                    row++;
                    count++;
                }
                break;
            case DOWN:
                if(row > 0){
//                    現在の空白ブロックの位置：row, col
//                    交換される位置: row - 1, col
                    int temp = imageData[row][col];
                    imageData[row][col] = imageData[row - 1][col];
                    imageData[row - 1][col] = temp;
//                    現在のブロックの位置を更新
                    row--;
                    count++;
                }
                break;
            case LEFT:
                if (col < imageData.length - 1){
//                    現在の空白ブロックの位置：row, col
//                    交換される位置：row, col + 1
                    int temp = imageData[row][col];
                    imageData[row][col] = imageData[row][col + 1];
                    imageData[row][col + 1] = temp;
//                    現在のブロックの位置を更新
                    col++;
                    count++;
                }
                break;
            case RIGHT:
                if(col > 0){
//                     現在の空白ブロックの位置：row, col
//                     交換される位置：row, col - 1
                    int temp = imageData[row][col];
                    imageData[row][col] = imageData[row][col - 1];
                    imageData[row][col - 1] = temp;
//                    現在のブロックの位置を更新
                    col--;
                    count++;
                }
                break;
        }
//         インターフェースを再描画！！！
        initImage();
    }

    private void initRandomArray() {
//        二次元配列の要素の順序をランダム化
        for (int i = 0; i < imageData.length; i++) {
            for (int j = 0; j < imageData[i].length; j++) {
//                ランダムな位置を生成
                int k1 = (int)(Math.random()*imageData.length);
                int l1 = (int)(Math.random()*imageData.length);

                int k2 = (int)(Math.random()*imageData.length);
                int l2 = (int)(Math.random()*imageData.length);
//                二つの位置の要素を交換
                int temp = imageData[k1][l1];
                imageData[k1][l1] = imageData[k2][l2];
                imageData[k2][l2] = temp;
            }
        }
//        空白ブロックの位置を特定
//        二次元配列を走査し、データが0の場合はその位置を記録
        OUT:
        for (int i = 0; i < imageData.length; i++) {
            for (int j = 0; j < imageData[i].length; j++) {
                if (imageData[i][j] == 0) {
//                    空白ブロックの位置を特定
                    row = i;
                    col = j;
                    break OUT;//ループを抜ける
                }
            }
        }

    }

    private void initMenu(){
        JMenuBar menuBar = new JMenuBar();//メニューバーオブジェクトを作成
        JMenu menu = new JMenu("システム");//メニューオブジェクトを作成
        JMenuItem exitJi = new JMenuItem("終了");//メニューアイテムオブジェクトを作成
        menu.add(exitJi);//メニューアイテムを追加
        exitJi.addActionListener(e -> {
            dispose();//ウィンドウを破棄
        });

        JMenuItem restartJi = new JMenuItem("再開");
        menu.add(restartJi);//メニューアイテムをメニューに追加
        restartJi.addActionListener(e -> {
//            ゲームを再開：二次元配列の順序を再度ランダム化し、インターフェースを再描画
            count = 0;//リセット
            initRandomArray();
            initImage();
        });

//       メニューをメニューバーに追加
        menuBar.add(menu);
        this.setJMenuBar(menuBar);
    }

    private void initImage(){
//        ウィンドウ上のすべてのレイヤーをクリア
        this.getContentPane().removeAll();

//        インターフェースを更新する際、ステップ数を表示可能：
        JLabel countTxt = new JLabel("現在の移動ステップ数："+ count + "ステップ");
        countTxt.setBounds(20, 490, 150, 20);
//        テキストを赤色で表示
        countTxt.setForeground(Color.red);
//        太字にする
        countTxt.setFont(new Font("楷体",Font.BOLD,12));
        this.add(countTxt);

//      初めてゲームをするかどうかを尋ね、履歴勝利ステップがないことを表示します。
        if (minCount != 0 ){
            JLabel countTxt2 = new JLabel("最小ステップ数："+ minCount + "ステップ");
            countTxt2.setBounds(300, 20, 130, 20);
//        テキストを白色で表示
            countTxt2.setForeground(Color.WHITE);
//        太字にする
            countTxt2.setFont(new Font("楷体",Font.BOLD,12));
            this.add(countTxt2);
        }else {
            JLabel countTxt2 = new JLabel("履歴ステップ数なし");
            countTxt2.setBounds(300, 20, 130, 20);
//        テキストを白色で表示
            countTxt2.setForeground(Color.WHITE);
//        太字にする
            countTxt2.setFont(new Font("楷体",Font.BOLD,12));
            this.add(countTxt2);
        }

//        インターフェースを更新したら勝利判定を行う
        if (isWin()){
//            勝利画像を表示
            JLabel label = new JLabel(new ImageIcon(imagePath+"win.png"));
            label.setBounds(124,230,266,88);
            this.add(label);

//            ファイルから最小ステップ数を読み込み、更新が必要かどうか確認
            int fileMinCount = readFileScore();
//            ステップ数が0であるか、初めてゲームである場合、現在の勝利ステップ数を書き込む
            if (fileMinCount == 0 ||  count < fileMinCount){
                writeFileScore(count);
            }
        }

//    1，行列マトリクスの画像ブロックをウィンドウに並べて表示(4*4)
        for (int i = 0; i <imageData.length ; i++) {
            for (int j = 0; j <imageData[i].length ; j++) {
//               画像名を取得
                String imageName = imageData[i][j] + ".png";
//                2,JLabelオブジェクトを作成し、画像を設定して表示
                JLabel label = new JLabel();
//                3，画像をLabelオブジェクトに設定
                label.setIcon(new ImageIcon( imagePath + imageName));
//                4，画像の表示位置を設定
                label.setBounds(20+j*100,60+i*100,100,100);
//                5,この画像をウィンドウに表示
                this.add(label);
            }
        }

//        ウィンドウの背景画像を設定
        JLabel background =new JLabel(new ImageIcon(imagePath+"background.png"));
        background.setBounds(0, 0, 450, 484);
        this.add(background);

//        レイヤーを更新し、再描画
        this.repaint();
    }

    private void writeFileScore(int count){
        try(
                FileWriter fw = new FileWriter("stone-maze/src/score.txt");
                BufferedWriter bw = new BufferedWriter(fw);
        ){
//           現在のステップ数をファイルに書き込む
            bw.write(count+"");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //    score.txtファイルから最小ステップ数を読み込む
    private int readFileScore() {
        try(
//            最小ステップ数を読み込む
                FileReader fr = new FileReader("stone-maze/src/score.txt");
                BufferedReader br = new BufferedReader(fr);
        ){
            String line = br.readLine();
            return Integer.valueOf(line);
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }

    private boolean isWin() {
//        ゲームの二次元配列と勝利後の二次元配列の内容が同じかどうかを判定。
//        一つの位置でもデータが異なる場合は勝利していない
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (imageData[i][j] != winData[i][j]) {
                    return false;
                }
            }
        }
//         勝利
        return true;
    }

    private void initFrame(){
//    ウィンドウタイトルを設定
        this.setTitle("石子迷陣");
//    ウィンドウの高さを設定
        this.setSize(465,575);
//    ウィンドウの閉じ方を設定
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//    ウィンドウを中央に表示
        this.setLocationRelativeTo(null);
//    ウィンドウの絶対レイアウトを設定
        this.setLayout(null);

    }
}

