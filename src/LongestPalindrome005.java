public class LongestPalindrome005 {

    public static void main(String[] args) {
        new LongestPalindrome005().longestPalindrome("babad");
    }

    public String longestPalindrome(String s) {
        int start = 0;
        int end = 0;
        for(int i = 0; i < s.length(); i++){
            int len1 = find(s, i, i);
            int len2 = find(s, i, i+1);
            int maxlen = Math.max(len1, len2);
            if(maxlen > (end - start+1)){
                start = i - (maxlen-1)/2;
                end = i + (maxlen)/2;
            }
        }
        return s.substring(start, end+1);
    }

    private int find(String s, int L, int R){
        while(L >= 0 && R < s.length() && s.charAt(L)==s.charAt(R)){
            L--;
            R++;
        }
        return R-L-1;
    }

}
