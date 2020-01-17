import java.util.ArrayList;
import java.util.List;

public class Subsets078 {

    List<List<Integer>> results = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        results.add(new ArrayList<>());
        for (int num : nums) {
            List<List<Integer>> result_temp = new ArrayList<>();
            for (List<Integer> result : results) {
                List<Integer> temp = new ArrayList<>(result);
                temp.add(num);
                result_temp.add(temp);
            }
            results.addAll(result_temp);
        }
        return results;
    }
}
