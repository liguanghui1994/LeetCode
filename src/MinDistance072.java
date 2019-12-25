public class MinDistance072 {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        if(m == 0 || n == 0){
            return m+n;
        }
        int[][] result = new int[m+1][n+1];
        generate(result, word1, word2, m+1, n+1);
        return result[m][n];
    }

    private void generate(int[][] result, String word1, String word2, int m, int n) {
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(j == 0){
                    result[i][j] = i;
                }else if(i == 0){
                    result[i][j] = j;
                }else{
                    int delete = result[i-1][j]+1;//把word1的前n-1个和word2调整为一致，然后删除word1的第n个
                    int insert = result[i][j-1]+1;//把word1和word2的前n-1个调整为一致，然后往word1最后插入一个
                    int replace = result[i-1][j-1]+1;//把word1的n-1和word2的n-1调整为一致，然后其中一个word替换最后一个字符即可
                    if(word1.charAt(i-1) == word2.charAt(j-1)){
                        replace = result[i-1][j-1];
                    }
                    result[i][j] = Math.min(delete,Math.min(insert, replace));
                }
            }
        }
    }

    public static void main(String[] args){
        String word2 = "pneumonoultramicroscopicsilicovolcanoconiosis";
        String word1 = "ultramicroscopically";
        new MinDistance072().minDistance(word1, word2);
    }
}
