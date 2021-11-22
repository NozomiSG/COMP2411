import java.util.Arrays;

public class Test_13 {
    public static void main(String[] args) {
        long sum = 0;
        long iterNum = 10;
        long[] nums = new long[100];
        nums[0] = 1;
        nums[1] = 1;
        for (int n=1; n<iterNum; n++) {
            sum += nums[n];
            nums[n+1] = 2*sum*nums[n] - nums[n]*nums[n];
        }
        System.out.println(Arrays.toString(nums));

    }
}
