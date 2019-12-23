public class SearchRange034 {

    public static void main(String[] args) {
        int[] nums = new int[]{8,8};
        new SearchRange034().searchRange(nums, 8);
    }

    public int[] searchRange(int[] nums, int target) {
        int[] nullvalue = new int[]{-1, -1};
        if(nums == null || nums.length == 0){
            return nullvalue;
        }
        int left = searchLeftOrRight(nums, target, 0, nums.length-1, true);
        if(left == -1){
            return nullvalue;
        }
        int right = searchLeftOrRight(nums, target, left, nums.length-1, false);
        return new int[]{left, right};
    }

    public int searchLeftOrRight(int[] nums, int target, int start, int end, boolean left) {
        while(start <= end){
            int mid = start + (end - start >> 1);
            if(nums[mid] == target){
                if(start == end){
                    return mid;
                }
                if(left){
                    if(mid == 0 || (mid > 0 && nums[mid - 1] != target)){
                        return mid;
                    }else{
                        end = mid -1;
                    }
                }else{
                    if(mid == nums.length-1 || (mid < nums.length-1 && nums[mid + 1] != target)){
                        return mid;
                    }else{
                        start = mid + 1;
                    }
                }
            }else if(target > nums[mid]){
                start = mid + 1;
            }else{
                end = mid -1;
            }
        }
        return -1;
    }
}
