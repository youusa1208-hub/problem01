public class test3 {
    public static void main(String[] args) {

        // 6桁の認証コードを生成して表示
        System.out.println("認証コード: " +getcode(4));
        String code = getcode(6);
        System.out.println("認証コード: " + code);
    }

    /**
     * 指定した長さのランダムな認証コードを生成する
     * @param m コードの長さ
     * @return ランダムな認証コード（数字・小文字・大文字を含む）
     */
    public static String getcode(int m) {
        String code = "";
        for (int i = 0; i < m; i++) {
            int type = (int)(Math.random() * 3); // 0:数字, 1:小文字, 2:大文字
            switch (type) {
                case 0:
                    // 0～9の数字
                    int num = (int)(Math.random() * 10);
                    code += num;
                    break;
                case 1:
                    // a～zの小文字
                    char ch = (char)(Math.random() * 26 + 'a');
                    code += ch;
                    break;
                case 2:
                    // A～Zの大文字
                    char CH = (char)(Math.random() * 26 + 'A');
                    code += CH;
                    break;
            }
        }
        return code;
    }
}