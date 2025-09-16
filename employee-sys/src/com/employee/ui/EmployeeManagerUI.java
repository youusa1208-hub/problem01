package com.employee.ui;

import com.employee.bean.Employee;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

// カスタム従業員画面
public class EmployeeManagerUI extends JFrame{
    private JFrame frame; // ウィンドウ
    private JTable table;  // テーブル
    private DefaultTableModel model; // テーブルモデル: テーブルデータをカプセル化するオブジェクト
    private JTextField nameTextFieldSearch; // 検索入力ボックス
    // 静的コレクションオブジェクトを準備し、システム内のすべての従業員オブジェクト情報を格納する
    private static ArrayList<Employee> employees = new ArrayList<>();

    public EmployeeManagerUI() {
    }

    public  EmployeeManagerUI(String username) {
        super("ようこそ、" + username + "人事情報管理システムへ"); // ウィンドウタイトルを設定
        frame = this;
        initialize();
        this.setVisible(true); // ウィンドウを表示
    }

    private void initialize() {
        this.setBounds(100, 100, 800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(new BorderLayout());

        // 入力ボックスと検索ボタン
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        nameTextFieldSearch = new JTextField(20);
        JButton btnSearch = new JButton("検索");
        JButton btnAdd = new JButton("追加");
        topPanel.add(nameTextFieldSearch);
        topPanel.add(btnSearch);
        topPanel.add(btnAdd);

        // テーブルモデルを作成
        model = new DefaultTableModel(
                new Object[][]{},
                new String[]{"ID", "名前", "性別", "年齢", "電話" ,"職位", "入社日", "給与", "部署"}
        ){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // すべてのセルを編集不可に設定
            }
        };

        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        table.setRowHeight(30);

        // 右クリックメニュー
        JPopupMenu popupMenu = new JPopupMenu();
        JMenuItem editItem = new JMenuItem("編集");
        JMenuItem deleteItem = new JMenuItem("削除");
        popupMenu.add(editItem);
        popupMenu.add(deleteItem);
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON3) { // マウス右クリックを明確にチェック
                    int row = table.rowAtPoint(e.getPoint());
                    if (row >= 0) {
                        table.setRowSelectionInterval(row, row);
                        popupMenu.show(table, e.getX(), e.getY());
                    }
                }
            }
        });

        // メニューアイテムにイベントをバインド
        editItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow >= 0) {
                    int id = (Integer) model.getValueAt(selectedRow, 0); // IDは最初の列にあると仮定
                    JOptionPane.showMessageDialog(frame, "削除 ID: " + id);
                    // ここに編集ロジックを追加できる。例えば、新しいダイアログを開いてユーザーにデータの変更をさせる
                }
            }
        });

        deleteItem.addActionListener(e -> {
            int selectedRow = table.getSelectedRow(); // 選択された行インデックスを取得
            if (selectedRow >= 0) {
                int id = (Integer) model.getValueAt(selectedRow, 0); // IDは最初の列にあると仮定
                // JOptionPane.showMessageDialog(frame, "削除 ID: " + id);
                // ここに削除ロジックを追加できる。例えば、モデルから該当行を削除する
                deleteEmployee(id);
                model.removeRow(selectedRow); // 現在の行を削除
            }
        });

        // 検索ボタンリスナー
        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchValue = nameTextFieldSearch.getText();
                // ここに検索ロジックを追加
            }
        });

        // 追加ボタンリスナー
        btnAdd.addActionListener(e -> {
            // 従業員情報追加画面をポップアップ表示
            new AddEmployeeUI(this);
        });

        frame.getContentPane().add(topPanel, BorderLayout.NORTH);
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
    }

    private void deleteEmployee(int id) {
        // コレクションから該当する従業員オブジェクトを削除
        for (int i = 0; i < employees.size(); i++) {
            Employee employee = employees.get(i);
            if (employee.getId() == id) {
                employees.remove(i);
                break;
            }
        }
    }

    public void addEmployee(Employee employee) {
        // コレクションに追加し、テーブルに表示
        employees.add(employee);
        // データ行を追加
        model.addRow(new Object[]{employee.getId(), employee.getName(), employee.getSex(), employee.getAge(), employee.getPhone(), employee.getPosition(), employee.getEntryDate(), employee.getSalary(), employee.getDepartment()});
    }
}
