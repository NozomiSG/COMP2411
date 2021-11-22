import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test_12 {
    public static void main(String[] args) {
        List<Integer> ans = new ArrayList<>();
        ans.add(1);
        List<Integer> test = Arrays.asList(22,3,3);
        ans.addAll(test);
        System.out.println(ans);
    }
}
