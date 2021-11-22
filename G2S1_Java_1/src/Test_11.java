public class Test_11 {
    static void rec1(int[] a, int cur) {
        if (cur<0||cur>=a.length) return;
        System.out.println(a[cur]);
        if (a[cur]%2!=0)cur++; else cur--;
        rec2(a, cur);
    }
    static void rec2(int[] a, int cur) {
        rec1(a, cur+1);
        System.out.println(a[cur]);
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7,8,9,10};
        rec2(a, 3);
    }
}
