import java.util.Arrays;

public class Test_7 {

    /**
     * recursive bubble & insertion & selection
     */

    public static void main(String[] args) {
        int[] nums = {3,2,3,7,5,1,3,9,4,3,1};
        selection(nums, nums.length);
        System.out.println(Arrays.toString(nums));
    }

    public static void bubble(int[] nums, int num) {
        if (num <= 1) return;
        for (int n=0; n<num-1; n++) {
            if (nums[n]>nums[n+1]) {
                int mid = nums[n];
                nums[n] = nums[n+1];
                nums[n+1] = mid;
            }
        }
        bubble(nums, num-1);
    }

    public static void insertion(int[] nums, int num) {
        if (num <= 1) return;

        insertion(nums, num-1);

        int comp = nums[num-1];
        int n = num-2;
        for (; n>=0; n--) {
            if (nums[n] >= comp) {
                nums[n+1] = nums[n];
            }
            else break;
        }
        nums[n+1] = comp;
    }

    public static void selection(int[] nums, int num) {
        if (num <= 1) return;
        int pos = num-1;
        for (int n=0; n<num-1; n++) {
            if (nums[n]>nums[pos]) {
                pos = n;
            }
        }
        int mid = nums[pos];
        nums[pos] = nums[num-1];
        nums[num-1] = mid;

        selection(nums, num-1);
    }
}


