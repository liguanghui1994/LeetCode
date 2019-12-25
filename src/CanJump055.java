public class CanJump055 {
    public static void main(String[] args){
        int[] nums = new int[]{2,3,1,1,4};
        new CanJump055().canJump(nums);
    }

    public boolean canJump(int[] nums) {
        boolean[] canJumpBoolean = new boolean[nums.length];
        canJumpBoolean[nums.length-1] = true;
        for(int i = nums.length-2; i >= 0; i--){
            canJumpBoolean[i] = jumpCrcyle(i, canJumpBoolean, nums);
        }
        return canJumpBoolean[0];
    }

    private boolean jumpCrcyle(int i, boolean[] canJumpBoolean, int[] nums) {
        int maxlen = Math.min(i+nums[i], nums.length-1);
        for(int j = i+1; j <= maxlen; j++){
            if(canJumpBoolean[j]){
                return true;
            }
        }
        return false;
    }
}
