public class NextPermutation031 {

    public static void main(String[] args) {
        new NextPermutation031().nextPermutation(new int[]{1, 5, 1});
    }

    public void nextPermutation(int[] nums) {
        int i = nums.length -2;
        if(i<0){
            return;
        }
        while(i>=0&&nums[i+1]<=nums[i]){
            i--;
        }
        if(i>=0){
            int j = i+1;
            while(j<=nums.length-1 && nums[j]>nums[i]){
                j++;
            }
            int temp = nums[i];
            nums[i] = nums[j-1];
            nums[j-1] = temp;
        }
        reserve(nums, i+1);
    }

    private void reserve(int[] nums, int L) {
        int R = nums.length-1;
        while (L<R){
            if(nums[L]>nums[R]){
                int temp = nums[L];
                nums[L] = nums[R];
                nums[R] = temp;
            }
            L++;
            R--;
        }
    }
}
