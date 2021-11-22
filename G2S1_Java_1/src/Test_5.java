public class Test_5 {
    public static void main(String[] args) {
        String s = "HongKong";
        fun1(s);
        System.out.println();
        fun(s);
        System.out.println();
    }

    public static void fun1(String s) {
        if (s.length() == 0) return;
        System.out.print(s.charAt(0));
        fun2(s.substring(1));
    }

    public static void fun2(String s) {
        if (s.length() == 0) return;
        fun1(s.substring(1));
        System.out.print(s.charAt(0));
    }

    public static void fun(String s) {
        int n = 0;
        String m = "";
        while (n < s.length()) {
            System.out.print(s.charAt(n++));
            if (n == s.length()) break;
            m += s.charAt(n++);
        }
        for (int i=m.length()-1; i>=0; i--) {
            System.out.print(m.charAt(i));
        }
    }


}
