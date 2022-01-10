package leetcode.editor.cn;

//Java：统计特殊四元组
public class CountSpecialQuadruplets {
    public static void main(String[] args) {
        Solution solution = new CountSpecialQuadruplets().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countQuadruplets(int[] nums) {
            int len = nums.length, ans = 0;
            for (int i = 0; i < len; i++) {
                for (int j = i + 1; j < len; j++) {
                    for (int k = j + 1; k < len; k++) {
                        for (int l = k + 1; l < len; l++) {
                            if (nums[i] + nums[j] + nums[k] == nums[l]) {
                                ans ++;
                            }
                        }
                    }
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}