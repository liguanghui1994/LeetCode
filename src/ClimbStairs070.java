public class ClimbStairs070 {

    public int climbStairs(int n) {
        if(n <= 0){
            return 0;
        }
        int[] resuls = new int[n];
        for(int i = 0; i < n; i++){
            if(i == 0){
                resuls[i] = 1;
            }
            else if(i == 1){
                resuls[i] = 2;
            }else{
                resuls[i] = resuls[i-1]+resuls[i-2];
            }

        }
        return resuls[n-1];
    }
}
