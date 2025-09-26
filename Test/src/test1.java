import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

public class test1 {
    public static void main(String[] args) {
        //1. 重複しない6つの赤玉番号（1-35）と1つの青玉番号（1-15）をランダムに生成し、
        //   赤玉は昇順にソートして出力し、青玉は最後に出力する
        Set<Integer> red = new TreeSet<>();
        while (red.size() < 6) {
            int redNum = (int)(Math.random() * 35 + 1);//1-35
            red.add(redNum);
        }
        System.out.println("赤玉番号：" + red);
        int blue = (int)(Math.random() * 15 + 1);//1-15
        System.out.println("青玉番号：" + blue);

        //2. ユーザーが選択した番号を格納するセットを定義し、
        //   何個の赤玉と青玉が一致したかを判定する
        Set<Integer> luckRed = new TreeSet<>();
        Collections.addAll(luckRed,10,12,30,16,7,17);
        int luckBlue = 12;

        //3. ユーザーが何個の赤玉を当てたかを判定
        int redCount = 0;
        for (Integer Num : red) {
            if (luckRed.contains(Num)) {
                redCount++;
            }
        }
        System.out.println("ユーザーは" + redCount + "個の赤玉を当てました");

        //4. ユーザーが青玉を当てたかどうかを判定
        System.out.println("ユーザーは" + (luckBlue == blue ? "1個の青玉を当てました" :"0個の青玉を当てました"));
    }
}
