package leetcode.editor.cn;

import java.util.Arrays;

//Java：数组中最大数对和的最小值
public class MinimizeMaximumPairSumInArray {
    public static void main(String[] args) {
        Solution solution = new MinimizeMaximumPairSumInArray().new Solution();
        // TO TEST
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int max = 0;
        for (int i = 0, j = nums.length - 1; i < j;i ++, j --) {
            max = Math.max(max, (nums[i] + nums[j]));
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}