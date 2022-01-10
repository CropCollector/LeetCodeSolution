package leetcode.editor.cn;

//Java：跳跃游戏
public class JumpGame {
    public static void main(String[] args) {
        Solution solution = new JumpGame().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canJump(int[] nums) {
            int len = nums.length;
            int maxDis = 0;
            for (int i = 0; i < len; i++) {
                if (maxDis >= i) {
                    maxDis = Math.max(maxDis, i + nums[i]);
                    if (maxDis >= len - 1) {
                        return true;
                    }
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}