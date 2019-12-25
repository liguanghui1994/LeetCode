public class Rotate048 {

    public static void main(String[] args){

    }

    /**
     * 主要的思路在于，矩阵旋转90度，其实是四个边中每一个数字旋转90度，其实是四个边中对应位置的数字的一个位置的下移
     * 假设第一个边的位置为(i, j),则剩下三边为(j, n-i-1),(n-i-1, n-j-1),(n-j-1, i)
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for(int i = 0; i < n/2; i++){
            for(int j = i; j < n-i-1; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-j-1][i];
                matrix[n-j-1][i] = matrix[n-i-1][n-j-1];
                matrix[n-i-1][n-j-1] = matrix[j][n-i-1];
                matrix[j][n-i-1] = temp;
            }
        }
    }

}
