package leetcode.editor.cn;

import java.util.Arrays;

//Java：有效三角形的个数
public class ValidTriangleNumber {
    public static void main(String[] args) {
        Solution solution = new ValidTriangleNumber().new Solution();
        solution.triangleNumber(new int[]{2, 2, 3, 4});
        // TO TEST
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int triangleNumber(int[] nums) {
        if (nums.length < 3) {
            return 0;
        }
        int ans = 0;
        Arrays.sort(nums);
        for (int i = 0; i <= nums.length - 3; i++) {
            if (nums[i] == 0) continue;
            for (int j = i + 1; j <= nums.length - 2; j++) {
                int sum = nums[i] + nums[j];
                int r = binarySearch(nums, sum, j);
                ans += r - j;
            }
        }
        return ans;
    }

    private int binarySearch(int[] nums, int sum, int left) {
        int l = left, r = nums.length;
        int pos = left;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (nums[mid] >= sum) {
                r = mid;
            } else {
                pos = mid;
                l = mid + 1;
            }
        }
        return pos;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}