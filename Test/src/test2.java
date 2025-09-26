import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

public class test2 {
    public static void main(String[] args) {
        //        オブジェクト指向プログラミングを使用：1人の囚人を表すオブジェクトを作成（最初の位置とランダム番号）
        //        1. ArrayListコレクションを作成し、100人の囚人を格納する
        List<Prisoner> Prisoners = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            int code = (int) (Math.random() * 200) + 1;//ランダム番号
            //            この番号が重複しているかチェック
            if (isRepeat(Prisoners,code)){
                //番号が重複している
                i--;
                continue;//今回のループをスキップ
            }

            Prisoner p = new Prisoner(code, i + 1);
            Prisoners.add(p);
        }
        System.out.println(Prisoners);

        //        2. コレクション内の奇数位置の囚人を削除し、最後の1人になるまで続ける
        while(true){
            List<Prisoner> lastPrisoners = new ArrayList<>();
            for (int i = 1; i < Prisoners.size(); i+=2) {
                lastPrisoners.add(Prisoners.get(i));
            }
            if (lastPrisoners.size() == 1){
                Prisoner prisoner = lastPrisoners.get(0);
                System.out.println("最後に残った囚人は：番号：" + prisoner.getId() + "、位置：" + prisoner.getFirstLocation());
                break;
            }
            Prisoners  = lastPrisoners;
        }
    }

    public static boolean isRepeat(List<Prisoner> Prisoners, int code){
        for (Prisoner p : Prisoners) {
            if (p.getId() == code){
                return true;
            }
        }
        return false;
    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Prisoner{
    private int id;//ランダム番号
    private int firstLocation;//最初の位置
}
