import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BalancedBrackets {

    public static boolean isBalanced(String s){
        int l = s.length();
        if (l%2==1) return false;
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        Stack<Character> stack = new Stack<>();
        for (int n=0; n<l; n++) {
            char c = s.charAt(n);
            if (c==')'||c==']'||c=='}') {
                if (stack.isEmpty()||stack.peek()!=map.get(c)) {
                    return false;
                } else
                    stack.pop();
            } else
                stack.push(c);
        }
        return stack.isEmpty();
    }
}
