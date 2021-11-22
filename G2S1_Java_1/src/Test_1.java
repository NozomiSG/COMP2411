import java.util.Scanner;

public class Test_1 {
    public static void main(String[] args) {
        test();
//        Scanner scanner = new Scanner(System.in);
//        int num = scanner.nextInt();
//        System.out.println(prime_number(num));
    }

    public static boolean prime_number(int n) {
        if (n == 2) return true;

        if (n%2 == 0 || n <= 1) return false;

        for (int i=3; i*i<=n; i+=2) {
            if (n%i == 0) return false;
        }
        return true;
    }

    public static void test() {
        int a, b, c;
        a = b = c = 10;
        System.out.println(a+' '+b+' '+c);
    }
}
