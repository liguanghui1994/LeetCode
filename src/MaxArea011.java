public class MaxArea011 {

    public int maxArea(int[] height) {
        int L = 0;
        int R = height.length-1;
        int maxarea = Math.min(height[L],height[R])*(R-L);
        while(R>L){
            if(height[L]>height[R]){
                R--;
            }else{
                L++;
            }
            int temp_maxarea = Math.min(height[L],height[R])*(R-L);
            maxarea = temp_maxarea > maxarea ? temp_maxarea : maxarea;
        }
        return maxarea;
    }
}
