import java.util.HashMap;
import java.util.Map;

public class NodoubleString003 {

    public static void main(String[] args) {
        new NodoubleString003().lengthOfLongestSubstring("abcabcbb");
    }

    public int lengthOfLongestSubstring(String s) {
        int one = 0;
        int two = 0;
        int maxlength = 0;
        Map<Character, Integer> strs = new HashMap<>();
        while(two < s.length()){
            Integer j ;
            if((j = strs.get(s.charAt(two))) != null){
                if(maxlength < (two-one)){
                    maxlength = two-one;
                }
                if(one < s.length()-1) {
                    one = Math.max(one, j+1);
                }
            }
            strs.put(s.charAt(two), two);
            two++;

        }
        if(maxlength < (two-one)){
            maxlength = two-one;
        }
        return maxlength;
    }

}
