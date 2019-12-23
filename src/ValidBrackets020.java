import java.util.Stack;

public class ValidBrackets020 {

    public boolean isValid(String s) {
        if(s == null || "".equals(s)){
            return true;
        }
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char current = s.charAt(i);
            if('(' == current || '{' == current || '[' ==current){
                stack.push(current);
            }else if(')' == current || '}' == current || ']' ==current){
                if(stack.empty()){
                    return false;
                }
                if(')' == current && stack.peek() == '('){
                    stack.pop();
                }
                else if('}' == current && stack.peek() == '{'){
                    stack.pop();
                }
                else if(']' == current && stack.peek() == '['){
                    stack.pop();
                }else{
                    return false;
                }
            }else{
                return false;
            }
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        new ValidBrackets020().isValid("()[]{}");
    }
}
