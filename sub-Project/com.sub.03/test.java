import com.Demo.Demo.Movie;
import com.Demo.Demo.MovieOperator;

public class test {
    public static void main(String[] args) {
        Movie[] movies = new Movie[6];
//      初期状態: Movie = [null,null,null,null,null,null]

//         各配列要素に映画オブジェクトを格納
        movies[0] = new Movie(1,"《君たちはどう生きるか》", 9.8,"山時聡真" );
        movies[1] = new Movie(2,"《アーヤと魔女》", 9.7,"寺島しのぶ" );
        movies[2] = new Movie(3,"《思い出のマーニー》", 9.6,"高月彩良" );
        movies[3] = new Movie(4,"《かぐや姫の物語》", 9.5,"朝倉あき" );
        movies[4] = new Movie(5,"《風立ちぬ》", 9.4,"庵野秀明" );
        movies[5] = new Movie(6,"《コクリコ坂から》", 9.3,"長澤まさみ" );

//        映画操作オブジェクトを作成（映画配列を渡す）
        MovieOperator mo = new MovieOperator(movies);
//        すべての映画情報を表示
        mo.prinAllMovies();//ALT+ENTER，自動生成
//        IDによる映画検索機能を実行
        mo.searchMovieById();


    }
}
