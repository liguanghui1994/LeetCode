import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams049 {

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> results = new ArrayList<>();
        if(strs == null || strs.length == 0){
            return results;
        }
        Map<StringArray, List<String>> mapping = new HashMap<>();
        for (String str : strs) {
            int[] chars = new int[26];
            for(int i = 0; i < str.length(); i++){
                chars[str.charAt(i)-'a']++;
            }
            StringArray stringArray = new StringArray(chars);
            List<String> list = mapping.get(stringArray);
            if(list == null){
                list = new ArrayList<>();
                mapping.put(stringArray, list);
            }
            list.add(str);
        }
        results = new ArrayList<>(mapping.values());
        return results;
    }

    static class StringArray{
        private int[] chars;
        private int hashcode;

        public StringArray(int[] chars) {
            this.chars = chars;
        }

        @Override
        public int hashCode() {
            if(hashcode!=0){
                return hashcode;
            }
            inithashCode();
            return hashcode;
        }

        public void inithashCode() {
            int hash = 1315423911;
            int len = this.chars.length;

            for(int i = 1; i < len; ++i) {
                if(chars[i] != 0)
                hash ^= (hash << 5) + chars[i] + (hash >>> 2);
            }
            this.hashcode = hash;
        }

        public int[] getChars() {
            return chars;
        }

        public void setChars(int[] chars) {
            this.chars = chars;
        }

        @Override
        public boolean equals(Object obj) {
            if(obj != null && obj instanceof StringArray){
                for (int i = 0, len = chars.length; i < len; i++) {
                    if(this.chars[i] != ((StringArray)obj).getChars()[i]){
                        return false;
                    }
                }
                return true;
            }
            return false;
        }
    }

}
