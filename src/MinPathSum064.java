public class MinPathSum064 {
    public int minPathSum(int[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int[][] maxnums = new int[m][n];
        generate(maxnums, grid, m, n);
        return maxnums[0][n-1];
    }

    private void generate(int[][] maxnums, int[][] grid, int m, int n) {
        for(int i = m-1; i >= 0; i--){
            for(int j = n-1; j >= 0; j--){
                if(i == m-1 && j == n-1){
                    maxnums[i][j] = grid[i][j];
                }else if(i == m-1){
                    maxnums[i][j] = grid[i][j]+maxnums[i][j+1];
                }else if(j == n-1){
                    maxnums[i][j] = grid[i][j]+maxnums[i+1][j];
                }else{
                    maxnums[i][j] = grid[i][j]+Math.min(maxnums[i][j+1], maxnums[i+1][j]);
                }
            }
        }
    }

    public static void main(String[] args){
        int[][] grid = new int[][]{{1,3,1},{1,5,1},{4,2,1}};
        new MinPathSum064().minPathSum(grid);
    }
}
