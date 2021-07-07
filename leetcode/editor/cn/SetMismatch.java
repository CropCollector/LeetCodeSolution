package leetcode.editor.cn;

import java.util.Arrays;

//Java：错误的集合
public class SetMismatch {
    public static void main(String[] args) {
        Solution solution = new SetMismatch().new Solution();
        // TO TEST
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] findErrorNums(int[] nums) {
        int repeat = 0, miss = 0;
        int[] arr = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            if (arr[nums[i]] != 0) {
                repeat = nums[i];
            } else {
                arr[nums[i]] = 1;
            }
        }
        for (int i = 1; i <= arr.length; i++) {
            if (arr[i] == 0) {
                miss = i;
                break;
            }
        }
        return new int[]{repeat, miss};
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}