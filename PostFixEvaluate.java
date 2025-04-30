import java.util.Stack;

public class PostFixEvaluate {
    public static float calculate(Float operand_1, char operator, Float operand_2) {
        /* 請實作function計算operand_1及operand_2的值 */
        if(operator == '+'){
            return operand_1 + operand_2;
        }
        if(operator == '-'){
            return operand_1 - operand_2;
        }
        if(operator == '*'){
            return operand_1 * operand_2;
        }
        return operand_1 / operand_2;
    }
    public static float postFixEvaluation(String expr){
        Stack<Float> stack = new Stack<>();
        /* 請使用課本的pseudocode實作後續求值演算法 */
        //todo
        int index = 0;
        while(index < expr.length()){
            char judgeOperand = expr.charAt(index);//使用while迴圈和charAt方法得到字串的所有字元
            if(judgeOperand != '+' && judgeOperand != '-' && judgeOperand != '*' && judgeOperand != '/'){
                stack.push((float)judgeOperand - '0');//ASCII中字元'0'以十進位表示為48, 1-9為49到57,
                                                           //所以數字的字元強轉成float要減掉'0'才會是正確的值
            }
            else{
                float operand2 = stack.pop();
                float operand1 = stack.pop();
                float value = calculate(operand1, judgeOperand, operand2);
                stack.push(value);
            }
            index++;
        }

        return stack.pop();
    }
}
