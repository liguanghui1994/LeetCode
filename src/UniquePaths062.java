public class UniquePaths062 {
    int[][] rules;
    public int uniquePaths(int m, int n) {
        if(m <= 0 || n <= 0){
            return 0;
        }
        rules = new int[m][n];
        generate(m,n);
        return rules[m-1][n-1];
    }

    /**
     * 动态规划，rules[i][j] = rules[i - 1][j] + rules[i][j - 1]
     * @param m
     * @param n
     */
    private void generate(int m, int n) {
        for(int i = 0; i < m; i++){
            for(int j = 0; j< n; j++){
                if(i == 0 || j == 0){
                    rules[i][j] = 1;
                }else {
                    rules[i][j] = rules[i - 1][j] + rules[i][j - 1];
                }
            }
        }
    }

    public static void main(String[] args){
        new UniquePaths062().uniquePaths(3,2);
    }
}
