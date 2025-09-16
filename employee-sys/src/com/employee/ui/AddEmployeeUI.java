package com.employee.ui;

import com.employee.bean.Employee;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;

public class AddEmployeeUI extends JFrame {
    private JTextField txtId, txtName, txtSex, txtAge, txtPhone, txtPosition, txtSalary, txtDepartment;
    private JFormattedTextField txtHireDate;
    private JButton btnSave, btnCancel;
    private EmployeeManagerUI employeeManagerUI;

    // 従業員情報追加画面の初期化：複数の入力項目を提供
    // "ID", "名前","年齢","電話","職位","入社日","給与","部署"
    // 追加ボタンとキャンセルボタンを提供
    public AddEmployeeUI(EmployeeManagerUI employeeManagerUI) {
        super("従業員情報追加");
        this.employeeManagerUI = employeeManagerUI;
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        Font labelFont = new Font("楷体", Font.PLAIN, 14);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        JLabel idLabel = new JLabel("ID:");
        idLabel.setFont(labelFont);
        add(idLabel, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        txtId = new JTextField(10);
        add(txtId, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        JLabel nameLabel = new JLabel("名前:");
        nameLabel.setFont(labelFont);
        add(nameLabel, gbc);

        gbc.gridx = 1;
        txtName = new JTextField(10);
        add(txtName, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        JLabel sexLabel = new JLabel("性別:");
        sexLabel.setFont(labelFont);
        add(sexLabel, gbc);

        gbc.gridx = 1;
        txtSex = new JTextField(10);
        add(txtSex, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        JLabel ageLabel = new JLabel("年齢:");
        ageLabel.setFont(labelFont);
        add(ageLabel, gbc);

        gbc.gridx = 1;
        txtAge = new JTextField(10);
        add(txtAge, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        JLabel phoneLabel = new JLabel("電話番号:");
        phoneLabel.setFont(labelFont);
        add(phoneLabel, gbc);

        gbc.gridx = 1;
        txtPhone = new JTextField(10);
        add(txtPhone, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        JLabel positionLabel = new JLabel("職位:");
        positionLabel.setFont(labelFont);
        add(positionLabel, gbc);

        gbc.gridx = 1;
        txtPosition = new JTextField(10);
        add(txtPosition, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        JLabel hireDateLabel = new JLabel("入社日:");
        hireDateLabel.setFont(labelFont);
        add(hireDateLabel, gbc);

        gbc.gridx = 1;
        txtHireDate = new JFormattedTextField(new SimpleDateFormat("yyyy-MM-dd"));
        add(txtHireDate, gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        JLabel salaryLabel = new JLabel("給与:");
        salaryLabel.setFont(labelFont);
        add(salaryLabel, gbc);

        gbc.gridx = 1;
        txtSalary = new JTextField(10);
        add(txtSalary, gbc);

        gbc.gridx = 0;
        gbc.gridy = 8;
        JLabel departmentLabel = new JLabel("部署:");
        departmentLabel.setFont(labelFont);
        add(departmentLabel, gbc);

        gbc.gridx = 1;
        txtDepartment = new JTextField(10);
        add(txtDepartment, gbc);

        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.NONE;
        btnSave = new JButton("追加");
        btnCancel = new JButton("キャンセル");
        btnSave.setPreferredSize(new Dimension(100, 30));
        btnCancel.setPreferredSize(new Dimension(100, 30));
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(btnSave);
        buttonPanel.add(btnCancel);
        add(buttonPanel, gbc);

        // 従業員情報追加のクリックイベントリスナーをバインド
        btnSave.addActionListener(e -> {
            // 入力フィールドのデータを取得し、従業員オブジェクトにカプセル化し、情報画面のコレクションに追加してテーブルに表示
            Employee employee = new Employee();
            employee.setId(Integer.parseInt(txtId.getText()));
            employee.setName(txtName.getText());
            employee.setSex(txtSex.getText());
            employee.setAge(Integer.parseInt(txtAge.getText()));
            employee.setPhone(txtPhone.getText());
            employee.setPosition(txtPosition.getText());
            employee.setEntryDate(txtHireDate.getText());
            employee.setSalary(Double.parseDouble(txtSalary.getText()));
            employee.setDepartment(txtDepartment.getText());
            // この従業員オブジェクトを情報画面に送信し、情報画面のコレクションに追加し、情報画面のテーブルに表示
            employeeManagerUI.addEmployee(employee);
            // 成功メッセージを表示
            JOptionPane.showMessageDialog(this, "追加成功！");
            // 現在のウィンドウを閉じる
            dispose();
        });

        pack();
        setSize(300, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}
