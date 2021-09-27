package leetcode.editor.cn;

import java.util.Arrays;

//Java：二分查找
public class BinarySearch {
    public static void main(String[] args) {
        Solution solution = new BinarySearch().new Solution();
        // TO TEST
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int search(int[] nums, int target) {
        int ans = -1;
        int l = 0, r = nums.length;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (nums[mid] == target) {
                ans = mid;
                break;
            } else if (nums[mid] > target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}