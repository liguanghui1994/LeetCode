import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum015 {

    public static void main(String[] args) {
        new ThreeSum015().threeSum(new int[]{-1,0,1,2,-1,-4});
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if(nums.length == 0){
            return results;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-2; i++) {
            //如果当前值跟前一个一样，那前一个已经判断过了，再次判断为重复的，跳过
            while(i>0 && i < nums.length-2 && nums[i] == nums[i-1]){
                i++;
            }
            if(nums[i]>0){
                break;
            }
            int L = i + 1;
            int R = nums.length-1;
            while (L < R){
                int sum = nums[i]+nums[L]+nums[R];
                if(sum == 0){
                    results.add(Arrays.asList(new Integer[]{nums[i],nums[L],nums[R]}));
                    //如果R左边的值跟R一样，跳过R左边那个；
                    while(L < R && nums[R] == nums[R-1]){
                        R--;
                    }
                    //如果L右边的值跟L一样，跳过L右边那个
                    while(L < R && nums[L] == nums[L+1]){
                        L++;
                    }
                    R--;
                    L++;
                }else if(sum > 0){
                    R--;
                }else{
                    L++;
                }
                if(nums[R]<0){
                    break;
                }
            }
        }
        return results;
    }
}
