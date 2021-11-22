public class Test_8 {
    public static void main(String[] args) {
        getBirth("17/08/2002");
    }

    public static void getBirth(String birth) {
        if (birth.equals("")) {
            System.out.println("Error!");
            return;
        }
        int a, b;
        a = birth.indexOf('/');
        b = birth.indexOf('/', a+1);
        System.out.println("day: "+birth.substring(0, a));
        System.out.println("month: "+birth.substring(a+1, b));
        System.out.println("year: "+birth.substring(b+1));
    }
}
