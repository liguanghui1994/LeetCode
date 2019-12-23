import java.util.*;

public class CombinationSum039 {

    public static void main(String[] args) {
        int[] candidates = new int[]{2,3,6,7};
        CombinationSum039 combinationSum039 = new CombinationSum039();
        combinationSum039.combinationSum(candidates, 7);
    }

    List<List<Integer>> results = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates == null || candidates.length == 0){
            return results;
        }
        List<Integer> temp = new ArrayList<>();
        process(candidates, target, temp, 0);
        return results;
    }

    private void process(int[] candidates, int target, List<Integer> temp, int start) {
        if(target < 0){
            return;
        }else if(target == 0){
            results.add(new ArrayList<>(temp));
            return;
        }else{
            for(int i = start; i < candidates.length; i++){
                List<Integer> current = new ArrayList<>(temp);
                current.add(candidates[i]);
                process(candidates, target - candidates[i], current, i);
            }
        }
    }
}
