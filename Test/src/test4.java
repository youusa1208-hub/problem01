import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 要件

 *現在n個の物品があり、各物品は液体で、液体には重量と価値があります。以下の提供された液体の中から合計10リットルの液体のみを取り出すことができます。各液体は取らない、全部取る、または一部を取り出すことができます。取り出す10リットルの液体の最高価値はいくらですか？

 *      名称      重量(リットル)       総価値
 *      水           4            24
 *      牛乳         8            160
 *      五粮液       2            4000
 *      コーラ       6            108
 *      茅台         1            4000

 *  具体的な機能点は以下の通り
 *  1. 上記データの順序に従って、各液体データをプログラムに一度に追加してください（注意：オブジェクトを作成して各液体データをカプセル化し、ArrayListコレクションに追加できます）
 *  2. プログラムで取り出す10リットルの液体の最高価値を計算してください。また、10リットルの液体が具体的にどの液体で構成され、それぞれ何リットル取ったかを示してください。
 */
public class test4 {
    public static void main(String[] args) {
        //        1. 水オブジェクトを定義して各液体データを格納
        //        2. Listコレクションを定義して各オブジェクトを格納
        Liquid water = new Liquid("水",4,24);
        Liquid milk = new Liquid("牛乳",8,160);
        Liquid wine = new Liquid("五粮液",2,4000);
        Liquid cola = new Liquid("コーラ",6,108);
        Liquid moutai = new Liquid("茅台",1,4000);
        List<Liquid> liquids = new ArrayList<>();
        Collections.addAll(liquids,water,milk,wine,cola,moutai);
        //        3. listコレクションを液体価値の降順でソート
        liquids = liquids.stream().sorted((o1, o2) -> Double.compare(o2.getPrice(), o1.getPrice()))
                .collect(Collectors.toList());

        //        4. コレクションを走査し、上から下に向かって10リットルの液体を選択、これが最も高価な液体
        double total = 0;//最高価値
        int all = 10;//10リットル
        for (int i = 0; i < liquids.size(); i++) {
            Liquid liquid = liquids.get(i);
            //            10リットルに完全に達したか判定
            int volume = liquid.getVolume();
            if (volume >= all){
                System.out.println(liquid.getName() + "から" + all + "リットルを抽出");
                total += liquid.getPrice() * all;
                break;
            }else {
                System.out.println(liquid.getName() + "から" + volume + "リットルを抽出");
                total += liquid.getPrice() * volume;
                all -= volume;//残りのリットル数
            }
        }
        System.out.println("総価値:" + total);
    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Liquid{
    private String name;//名称
    private int volume;//重量
    private int value;//総価値
    //    1リットル当たりの単価を計算
    public double getPrice(){
        //        精密計算:BigDecimal
        BigDecimal value =  BigDecimal.valueOf(this.value);
        BigDecimal volume = BigDecimal.valueOf(this.volume);
        return value.divide(volume,2,BigDecimal.ROUND_HALF_UP).doubleValue();
    }
}
