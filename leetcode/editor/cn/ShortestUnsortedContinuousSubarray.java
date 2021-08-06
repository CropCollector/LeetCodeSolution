package leetcode.editor.cn;

import java.util.Arrays;

//Java：最短无序连续子数组
public class ShortestUnsortedContinuousSubarray {
    public static void main(String[] args) {
        Solution solution = new ShortestUnsortedContinuousSubarray().new Solution();
        // TO TEST
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int[] copyNum = nums.clone();
        Arrays.sort(copyNum);
        int start, end;
        for (start = 0; start < copyNum.length && copyNum[start] == nums[start]; start ++) {}
        for (end = copyNum.length - 1; end >= 0 && copyNum[end] == nums[end]; end --) {}
        return end - start > 0 ? end - start + 1 : 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}