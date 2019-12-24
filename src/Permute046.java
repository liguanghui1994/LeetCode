import java.util.ArrayList;
import java.util.List;

public class Permute046 {

    public static void main(String[] args){
        new Permute046().permute(new int[]{1, 2, 3});
    }

    List<List<Integer>> results = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        List<Integer> select = new ArrayList<>();
        genarate(nums, select);
        return results;
    }

    private void genarate(int[] nums, List<Integer> select) {
        if(select.size() == nums.length){
            results.add(new ArrayList<>(select));
            return;
        }
        for (int num : nums) {
            if(select.contains(num)){
                continue;
            }
            select.add(num);
            genarate(nums, select);
            select.remove(select.size()-1);
        }
    }
}
