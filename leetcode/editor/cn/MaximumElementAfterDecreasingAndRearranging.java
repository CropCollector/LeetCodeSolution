package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashSet;
import java.util.TreeSet;

//Java：减小和重新排列数组后的最大元素
public class MaximumElementAfterDecreasingAndRearranging {
    public static void main(String[] args) {
        Solution solution = new MaximumElementAfterDecreasingAndRearranging().new Solution();
        // TO TEST
        System.out.println(solution.maximumElementAfterDecrementingAndRearranging(new int[]{73, 98, 9}));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        arr[0] = 1;
        for (int i = 1; i < arr.length; i ++) {
            // arr[i]要么和arr[i - 1]相等，要么缩小到arr[i - 1] + 1
            arr[i] = Math.min(arr[i], arr[i - 1] + 1);
        }
        return arr[arr.length - 1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}