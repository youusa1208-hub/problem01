import java.util.Scanner;

/**
 * 映画操作クラス - 映画データの操作を行う
 * 映画一覧表示、ID検索などの機能を提供
 */
public class MovieOperator {
    // 映画配列を保持するプライベート変数
    private Movie[] movies;

    /**
     * コンストラクタ - 映画配列を初期化
     * @param movies 操作対象の映画配列
     */
    public MovieOperator(Movie[] movies){
        this.movies = movies;
    }

    /**
     * すべての映画情報を表示するメソッド
     * 映画ID、名称、主演、価格をタブ区切りで出力
     */
    public void prinAllMovies() {
        System.out.println("-------映画情報----------");
        // 配列のすべての要素を繰り返し処理
        for (int i = 0; i < movies.length; i++) {
            Movie m = movies[i];
            // 各映画の情報をタブ区切りで表示
            System.out.println(m.getId() + "\t" + m.getName() + "\t" + m.getActor() + "\t" + m.getPrice());
        }
    }

    /**
     * IDによる映画検索メソッド
     * ユーザーからIDを入力받り、該当する映画情報を表示
     */
    public void searchMovieById() {
        System.out.println("検索する映画のIDを入力してください：");
        // キーボード入力を受け取るScannerオブジェクトを作成
        Scanner sc = new Scanner(System.in);
        int id = sc.nextInt(); // IDを整数として読み込む

        // 映画配列を検索
        for (int i = 0; i < movies.length; i++) {
            Movie m = movies[i];
            // 入力されたIDと映画のIDが一致する場合
            if (m.getId() == id) {
                // 該当する映画情報を表示
                System.out.println(m.getId() + "\t" + m.getName() + "\t" + m.getActor() + "\t" + m.getPrice());
                return; // メソッドを終了
            }
        }
        // 該当する映画が見つからない場合
        System.out.println("指定されたIDの映画は見つかりませんでした");
    }
}
