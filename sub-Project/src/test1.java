import java.util.Scanner;

public class test1 {
    public static void main(String[] args) {
//        簡易電卓
        Scanner sc = new Scanner(System.in);
        System.out.println("一つ目の数字を入力してください：");
        double num1 = sc.nextDouble();
        
        System.out.println("二つ目の数字を入力してください：");
        double num2 = sc.nextDouble();
        
        System.out.println("（+，-，*，/）を入力してください：");
        String op = sc.next();        
        
        double result = calc(num1, num2, op);
        System.out.println("結果:" + result);
        }



    public static double calc(double num1, double num2, String op) {
        double result = 0;
        switch (op) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                result = num1 / num2;
                break;
            default:
                System.out.println("無効です");
        }
        return result;
    }


}
