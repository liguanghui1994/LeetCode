import java.util.HashMap;
import java.util.Map;

public class MinWindow076 {

    public static void main(String[] args){
        String s = "ADOBECODEBANC";
        String t = "ABC";
        new MinWindow076().minWindow(s, t);
    }

    public String minWindow(String s, String t) {
        Map<Character, Integer> t_counts = new HashMap<>();
        for(int i = 0; i < t.length(); i++){
            encrise(t, t_counts, i);
        }
        int start = 0;
        int end = 0;
        Integer r_start = null;
        Integer r_end = null;
        Map<Character, Integer> s_counts = new HashMap<>();
        while(end < s.length()){
            encrise(s, s_counts, end);
            if(!mapping(t_counts, s_counts)){
                end++;
            }else{
                while(start <= end) {
                    decrise(s, s_counts, start);
                    if(mapping(t_counts, s_counts)){
                        start++;
                    }else{
                        if(r_start == null || (end - start) < (r_end - r_start)){
                            r_start = start;
                            r_end = end;
                        }
                        start++;
                        end++;
                        break;
                    }
                }

            }
        }
        if(r_end == null){
            return "";
        }
        if(r_end < s.length()) {
            return s.substring(r_start, r_end + 1);
        }else{
            return s.substring(r_start);
        }
    }

    public void encrise(String s, Map<Character, Integer> t_counts, int i){
        Character current = s.charAt(i);
        Integer count = t_counts.get(current);
        if(count == null) count = 0;
        t_counts.put(current, ++count);
    }

    public void decrise(String s, Map<Character, Integer> t_counts, int i){
        Character current = s.charAt(i);
        Integer count = t_counts.get(current);
        t_counts.put(current, --count);
    }

    public boolean mapping(Map<Character, Integer> t_counts, Map<Character, Integer> s_counts){
        for (Map.Entry<Character, Integer> chars : t_counts.entrySet()) {
            Integer newvalue = s_counts.get(chars.getKey());
            Integer oldvalue = chars.getValue();
            if(newvalue == null || newvalue.compareTo(oldvalue)<0){
                return false;
            }
        }
        return true;
    }
}
