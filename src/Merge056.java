import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Merge056 {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        List<int[]> results = new ArrayList<>();
        for (int[] current : intervals) {
            if(results.size() > 0){
                int[] before = results.get(results.size()-1);
                if(current[0]<=before[1]){
                    current[0] = Math.min(current[0], before[0]);
                    current[1] = Math.max(current[1], before[1]);
                    results.set(results.size()-1, current);
                }else{
                    results.add(current);
                }
            }else {
                results.add(current);
            }
        }
        return results.toArray(new int[0][0]);
    }

}
