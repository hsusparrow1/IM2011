import java.util.Stack;

public class ParseParens {
    public static Boolean checkParens(String expr) {
        Stack<Character> stack = new Stack<>(); //因應課本將(壓入棧而將Integer改為Character
        /* 請使用課本的pseudocode實作後序求值演算法 */

        boolean isBalance = true;//將平衡設為true
        boolean notBalance = false;//不平衡設為false

        // todo
        /*
         *  請使用課本pseudocode實作，解析expr括號使否平衡
         *  若平衡請回傳true
         *  若不平衡請回傳false
         * */
        int looper = 0;

        while(looper < expr.length()){
            char character = expr.charAt(looper);//使用while迴圈和charAt方法得到字串的所有字元
            if(character == '('){
                stack.push(character);
            }
            else{
                if(character == ')'){
                    if(stack.isEmpty()){
                        System.out.println("Error: Closing parentheses is not matched.");
                        return notBalance;
                    }
                    else{
                        stack.pop();
                    }
                }
            }
            looper++;
        }

        if(!stack.isEmpty()){
            System.out.println("Error: Opening parentheses is not matched.");
            return notBalance;
        }

        return isBalance;

    }
}
