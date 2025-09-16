package com.employee.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//従業員情報:"ID", "名前","年齢","電話","職位","入社日","給与","部署"
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    private int id;//従業員ID
    private String name;//従業員名前
    private int age;//従業員年齢
    private String phone;//従業員電話
    private String position;//従業員職位
    private String entryDate;//従業員入社日
    private double salary;//従業員給与
    private String department;//従業員部署
    private String sex;//従業員性別
}
