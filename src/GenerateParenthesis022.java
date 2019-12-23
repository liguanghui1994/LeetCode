import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis022 {

    public static void main(String[] args) {
        new GenerateParenthesis022().generateParenthesis(4);
    }

    public List<String> generateParenthesis(int n) {
        List<String> all = new ArrayList<>();
        generate(n, n, "", all);
        return all;
    }

    private void generate(int left, int right, String current, List<String> strings) {
        if(left == 0 && right == 0){
            strings.add(current);
            return;
        }
        if(left > 0){
            generate(left-1, right, current+"(", strings);
        }
        if(left < right){
            generate(left, right-1, current+")", strings);
        }

    }


}
