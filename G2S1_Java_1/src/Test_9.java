public class Test_9 {


    /**
     * get max num in array nums
     * recursion and iteration
     */
    public static void main(String[] args) {
        int[] num = {1,3,2,5,3,2,63,24,100};
        System.out.println(recursiveMax(num, 0, num.length-1));
        System.out.println(max(num));
    }

    public static int recursiveMax(int[] nums, int left, int right) {
        if (left>=right) return nums[right];
        int mid = left + (right-left)/2;
        int a = recursiveMax(nums, left, mid);
        int b = recursiveMax(nums, mid+1, right);
        return Math.max(a, b);
    }

    public static int max(int[] a) {
        int n = a.length;
        int[] b;
        b = new int[n];
        for (int i=0; i<n; i++) b[i] = a[i];
        while (n>1) {
            for (int j=0; j<n/2; j++) {
                b[j] = Math.max(b[j * 2], b[j * 2 + 1]);
                if (n%2 != 0) b[n/2] = b[n-1];
                n = (n+1)/2;
            }
        }
        return b[0];
     }
}
