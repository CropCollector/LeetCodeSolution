package leetcode.editor.cn;

import java.util.*;
import java.util.stream.Collectors;

//Java：划分为k个相等的子集
public class PartitionToKEqualSumSubsets {
    public static void main(String[] args) {
        Solution solution = new PartitionToKEqualSumSubsets().new Solution();
        // TO TEST
        System.out.println(solution.canPartitionKSubsets(new int[]{1,1,1,1,2,2,2,2}, 4));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canPartitionKSubsets(int[] nums, int k) {
            int sum = Arrays.stream(nums).sum();
            if (sum % k != 0) {
                return false;
            }

            List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
            Collections.sort(list, Comparator.reverseOrder());
            int len = nums.length, target = sum / k;
            boolean[] flag = new boolean[len];
            return dfs(list, flag, k, 0, 0, target);
        }

        private boolean dfs(List<Integer> list, boolean[] flag, int remain, int index, int sum, int target) {
            if (remain == 1) {
                return true;
            }
            if (sum > target) {
                return false;
            }
            if (sum == target) {
                return dfs(list, flag, remain - 1, 0, 0, target);
            }
            if (index == list.size()) {
                return false;
            }
            if (!flag[index]) {
                flag[index] = true;
                if (dfs(list, flag, remain, index + 1, sum + list.get(index), target)) {
                    return true;
                }
                flag[index] = false;
            }
            return dfs(list, flag, remain, index + 1, sum, target);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}