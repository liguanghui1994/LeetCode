public class FindMedianSortedArrays004 {

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 3};
        int[] nums2 = new int[]{2};
        new FindMedianSortedArrays004().findMedianSortedArrays(nums1, nums2);
    }

    public double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        //为什么要让m小于n，这样可以保证j一定大于0
        if (m > n) { // to ensure m<=n
            int[] temp = A; A = B; B = temp;
            int tmp = m; m = n; n = tmp;
        }
        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;
            //这里也很巧妙，只要保证i小于m，j就一定会 >= 1，这样B[j-1]一定存在
            if (i < iMax && B[j - 1] > A[i]) {
                iMin = i + 1; // i is too small
            } else if (i > iMin && A[i - 1] > B[j]) {
                iMax = i - 1; // i is too big
            } else { // i is perfect
                int maxLeft;
                if (i == 0) {//A分成的leftA(空集) 和 rightA(A的全部)  所以leftPart = leftA(空集) + leftB,故maxLeft = B[j-1]。
                    maxLeft = B[j - 1];
                } else if (j == 0) { //B分成的leftB(空集) 和 rightB(B的全部)  所以leftPart = leftA + leftB(空集),故maxLeft = A[i-1]。
                    maxLeft = A[i - 1];
                } else { //排除上述两种特殊情况，正常比较
                    maxLeft = Math.max(A[i - 1], B[j - 1]);
                }
                if ((m + n) % 2 == 1) { //奇数，中位数正好是maxLeft
                    return maxLeft;
                }
                //偶数
                int minRight;
                if (i == m) {//A分成的leftA(A的全部) 和 rightA(空集)  所以rightPart = rightA(空集) + rightB,故minRight = B[j]。
                    minRight = B[j];
                } else if (j == n) {//B分成的leftB(B的全部) 和 rightB(空集)  所以rightPart = rightA + rightB(空集),故minRight = A[i]。
                    minRight = A[i];
                } else {//排除上述两种特殊情况，正常比较
                    minRight = Math.min(B[j], A[i]);
                }

                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }
}
