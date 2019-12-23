public class Search033 {
    public static void main(String[] args) {
        int[] nums = new int[]{4,5,6,7,0,1,2};
        new Search033().search(nums, 1);
    }

    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        int start = 0;
        int end = nums.length-1;
        while(start <= end) {
            int mid = start +(end - start >> 1);
            if(nums[mid] == target){
                return mid;
            }
            if(nums[start] == target){
                return start;
            }
            if(nums[end] == target){
                return end;
            }
            //前半部分有序
            if (nums[start] < nums[mid]) {
                //不在前半部分，那就直接跳过前半部分
                if (target < nums[start] || target > nums[mid]){
                    start = mid+1;
                }else{
                    //在前半部分，那就直接在前半部分找
                    end = mid - 1;
                }
            }
            //后半部分有序
            else {
                if(target < nums[mid] || target > nums[end]){
                    end = mid -1;
                }else{
                    start = mid + 1;
                }
            }
        }
        return -1;
    }
}
