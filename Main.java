import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 讀取鍵盤輸入
        System.out.println("請輸入中置式 : ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        // 檢查括號
        boolean isBalance = ParseParens.checkParens(input);

        if(!isBalance) {
            System.exit(0);
        }

        // 執行中序轉後序演算法
        String ans =  InToPostFix.infixToPostFix(input);

        // 執行後續求值演算法
        float value = PostFixEvaluate.postFixEvaluation(ans);

        System.out.println("Infix Expression: " + input);
        System.out.println("Postfix Expression: " + ans);
        System.out.println("Postfix Evaluation: " + value);
    }
}
