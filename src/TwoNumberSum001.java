import java.util.HashMap;
import java.util.Map;

public class TwoNumberSum001 {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4};
        int target = 5;
        int[] result = new TwoNumberSum001().twoSum(nums, target);
        System.out.println();
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numsmap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer j = null;
            if((j = numsmap.get(target-nums[i])) != null){
                return new int[]{i, j};
            }
            numsmap.put(nums[i], i);
        }
        return null;
    }
}
