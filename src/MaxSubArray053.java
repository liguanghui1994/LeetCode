public class MaxSubArray053 {

    /**
     * 直接从前往后遍历，然后累加每次的值，记录最大的值。如果当前累加值小于0，那么只会拖累后面的累计值，需要立马舍弃，然后从新开始累加
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int sum = 0;
        for (int num : nums) {
            sum = sum + num;
            if(sum>max){
                max = sum;
            }
            //累加值小于0了，继续累加只会使后面的值更小，需要舍弃，重新累加
            if(sum < 0){
                sum = 0;
            }
        }
        return max;
    }
}
