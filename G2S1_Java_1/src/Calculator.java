import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class Calculator {

    private Map<String, Integer> priority;//操作符优先级Map

    public Calculator() {
        initPriority();
    }

    private void initPriority() {
        this.priority = new HashMap<>();
        //这里的#号是操作符堆栈中的栈底元素，是为了程序方便处理而添加的
        this.priority.put("#", 0);
        this.priority.put("+", 1);
        this.priority.put("-", 1);
        this.priority.put("*", 2);
        this.priority.put("/", 2);
    }

    //得到操作符的优先级
    public int getPriority(String operator) {
        //这里括号进行特殊处理
        if (operator.matches("[()]")) {
            return -1;
        } else {
            return priority.get(operator);
        }
    }

    //判断优先级高低
    private boolean isPrior(String one, String another) {
        return getPriority(one) <= getPriority(another);
    }

    //得到栈顶元素
    private <T> T getTopEle(Stack<T> stack) {
        if (stack == null) {
            return null;
        } else {
            return stack.get(stack.size() - 1);
        }
    }

    /**
     * @param expression 算数表达式
     * @return
     * 将中缀表达式转换为后缀表达式
     */
    public Queue<String> toSuffix(String expression) {
        Queue<String> operandQueue = new LinkedList<>();//操作数队列
        Stack<String> operatorStack = new Stack<>();//操作符堆栈
        operatorStack.push("#");

        String current;
        String operator;
        String number;
        int start = 0;
        int end = 0;
        for (int i = 0; i < expression.length(); i++) {
            current = String.valueOf(expression.charAt(i));
            // 如果是数字，末尾标记end++
            if (current.matches("[\\d.]")) {
                // 如果数字是最后一个字符，直接将其入队列
                if (i == expression.length() - 1) {
                    operandQueue.add(current);
                } else {
                    end++;
                }
            } else {
                // 如果是字符
                // 如果是左括号，将其入栈
                if (current.equals("(")) {
                    operatorStack.push(current);
                } else {
                    // 如果是右括号和其它运算符，先将前面的数字入队列
                    number = expression.substring(start, end);
                    if (!number.isEmpty()) {
                        operandQueue.add(number);
                    }
                    // 如果是右括号，执行出栈操作，并将出栈的元素入队列，直到弹出栈的是左括号，左括号直接出栈
                    if (current.equals(")")) {
                        while (!getTopEle(operatorStack).equals("(")) {
                            operandQueue.add(operatorStack.pop());
                        }
                        operatorStack.pop();
                    } else {
                        // 如果是其它运算符，弹出所有优先级大于或者等于该运算符的栈顶元素，然后将该运算符入栈
                        operator = current;
                        while (isPrior(operator, getTopEle(operatorStack))) {
                            operandQueue.add(operatorStack.pop());
                        }
                        operatorStack.push(operator);
                    }
                }
                // 将指向数字的首尾指针加1
                start = end = i + 1;
            }
        }

        for (int i = operatorStack.size() - 1; i > 0; i--) {
            operandQueue.add(operatorStack.pop());
        }

        return operandQueue;
    }

}
