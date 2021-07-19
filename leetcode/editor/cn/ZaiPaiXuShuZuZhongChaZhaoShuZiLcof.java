package leetcode.editor.cn;

import java.util.Arrays;

//Java：在排序数组中查找数字 I
public class ZaiPaiXuShuZuZhongChaZhaoShuZiLcof {
    public static void main(String[] args) {
        Solution solution = new ZaiPaiXuShuZuZhongChaZhaoShuZiLcof().new Solution();
        // TO TEST
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int search(int[] nums, int target) {
        int i = Arrays.binarySearch(nums, target);
        if (i < 0) {
            return 0;
        }
        int count = 1;
        for (int j = i - 1; j >= 0; j--) {
            if (nums[i] == nums[j]) {
                count ++;
            } else {
                break;
            }
        }

        for (int j = i + 1; j < nums.length; j++) {
            if (nums[i] == nums[j]) {
                count ++;
            } else {
                break;
            }
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}