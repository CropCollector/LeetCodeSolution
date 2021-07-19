package leetcode.editor.cn;

import java.util.Arrays;
import java.util.stream.Collectors;

//Java：有序数组的平方
public class SquaresOfASortedArray {
    public static void main(String[] args) {
        Solution solution = new SquaresOfASortedArray().new Solution();
        // TO TEST
        solution.sortedSquares(new int[]{-4,-1,0,3,10});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] sortedSquares(int[] nums) {
        int i;
        for (i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                break;
            }
        }
        int[] result = new int[nums.length];
        for (int l = i - 1, r = i, k = 0; k < result.length; k ++) {
            if (l == -1) {
                result[k] = (int) Math.pow(nums[r], 2);
                r ++;
                continue;
            } else if (r == result.length) {
                result[k] = (int) Math.pow(nums[l], 2);
                l --;
                continue;
            }
            int ln = (int) Math.pow(nums[l], 2);
            int rn = (int) Math.pow(nums[r], 2);
            if (ln > rn) {
                result[k] = rn;
                r ++;
            } else {
                result[k] = ln;
                l --;
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}