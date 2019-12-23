import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinations017 {

    Map<Character, String> phone = new HashMap<Character, String>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};

    List<String> combines = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if(digits != null && digits != "")
        backup("", digits);
        return combines;
    }

    private void backup(String s, String digits) {
        if(digits.length() == 0){
            combines.add(s);
            return;
        }
        char current = digits.charAt(0);
        String letters = phone.get(current);
        for(int i = 0; i < letters.length(); i++){
            backup(s + letters.charAt(i), digits.substring(1));
        }
    }


    public static void main(String[] args) {
        LetterCombinations017 letterCombinations017 = new LetterCombinations017();
        letterCombinations017.letterCombinations("23");
        System.out.println();
    }

}
