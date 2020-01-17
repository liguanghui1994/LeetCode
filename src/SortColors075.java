public class SortColors075 {
    public void sortColors(int[] nums) {
        if(nums == null || nums.length == 0){
            return;
        }
        int p0 = 0;              //[0, p0-1]为0区域
        int p2 = nums.length - 1;//[p2+1, nums.length-1]为2区
        int cur = 0;             //当前遍历到的位置
        while(cur <= p2){
            if(nums[cur] == 0){
                swap(nums, cur, p0);
                cur++;
                p0++;
            }else if(nums[cur] == 2){
                //这种情况下，把右边的数字换到左边，这个数字还没有遍历到，因此cur不能右移
                swap(nums, cur, p2);
                p2--;
            }else{
                cur++;
            }
        }
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
