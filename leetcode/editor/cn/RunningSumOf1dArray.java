package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;

//Java：一维数组的动态和
public class RunningSumOf1dArray {
    public static void main(String[] args) {
        Solution solution = new RunningSumOf1dArray().new Solution();
        // TO TEST
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] runningSum(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        return nums;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}