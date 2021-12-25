package leetcode.editor.cn;

import java.util.HashMap;

//Java：缺失的第一个正数
public class FirstMissingPositive {
    public static void main(String[] args) {
        Solution solution = new FirstMissingPositive().new Solution();
        // TO TEST
        System.out.println(solution.firstMissingPositive(new int[]{3,4,-1,1}));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            while (nums[i] - 1 >= 0 && nums[i] - 1 < len && nums[i] != nums[nums[i] - 1]) {
                int tmp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = tmp;
            }
        }
        for (int i = 0; i < len; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return len + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}