package com.sub.05;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// 家電
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JD implements Switch{
    private String name;
    // 状態：オンまたはオフ。
    private boolean status; // false デフォルトはオフ。

    @Override
    public void press() {
        // 現在のデバイスのオン/オフを制御
        status = !status;
    }
}
