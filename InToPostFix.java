import java.util.Stack;

public class InToPostFix {

    public static int priority(char c){
        // 參考 priority of operators 表格
        // todo
        if(c == '*' || c == '/'){
            return 2;
        } else if (c == '+' || c == '-') {
            return 1;
        }

        return 0; // 依照表格return正確值
    }

    public static String infixToPostFix(String formula){
        Stack<Character> stack = new Stack<>(); // 建立空的Stack
        String postFix = ""; // 欲輸出的後續式
        /* 請使用課本的pseudocode實作中續轉後續演算法 */
        //todo
        int looper = 0;

        while(looper < formula.length()){
            char token = formula.charAt(looper);//使用while迴圈和charAt方法得到字串的所有字元
            if(token == '('){
                stack.push(token);
            }
            else if (token == ')') {
                token = stack.pop();
                while(token != '('){
                    postFix = postFix + token;
                    token = stack.pop();
                }
            }
            else if(token == '+' || token == '-' || token == '*' || token == '/'){
                while(!stack.isEmpty() && priority(token) <= priority(stack.peek())) {//stack.peek()功能同stackTop
                    char tokenOut = stack.pop();
                    postFix = postFix + tokenOut;
                }
                stack.push(token);
            }
            else{
                postFix = postFix + token;
            }
            looper++;
        }

        while(!stack.isEmpty()){
            char token = stack.pop();
            postFix = postFix + token;
        }

        return postFix;
    }

}
