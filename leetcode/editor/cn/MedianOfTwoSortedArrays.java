package leetcode.editor.cn;

//Java：寻找两个正序数组的中位数
public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        Solution solution = new MedianOfTwoSortedArrays().new Solution();
        // TO TEST
        System.out.println(solution.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        if (len1 == 1 && len2 == 0) {
            return nums1[0];
        }
        if (len1 == 0 && len2 == 1) {
            return nums2[0];
        }
        int mid = ((len1 + len2) >> 1) + 1;
        int i1 = 0, i2 = 0, midValue1 = 0, midValue2 = 0;
        for (int count = 1; count <= mid; count++) {
            midValue1 = midValue2;
            if (i1 == len1) {
                midValue2 = nums2[i2 ++];
            } else if (i2 == len2) {
                midValue2 = nums1[i1 ++];
            } else {
                if (nums1[i1] < nums2[i2]) {
                    midValue2 = nums1[i1 ++];
                } else {
                    midValue2 = nums2[i2 ++];
                }
            }
        }
        if (((len1 + len2) & 1) == 1) {
            // 单数
            return midValue2;
        } else {
            // 双数 取平均
            return (midValue1 + midValue2) / 2.0f;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}