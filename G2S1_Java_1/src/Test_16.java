import java.util.Queue;

public class Test_16 {

    public static void main(String[] args) {
        Calculator calculator;
        String infix;
        calculator = new Calculator();
        infix = "(8+9*10)-4/2+3";
        Queue<String> suffix = calculator.toSuffix(infix);
        for (int i = suffix.size(); i > 0; i--) {
            System.out.print(suffix.poll() + " ");
        }
        System.out.println();
    }
}
