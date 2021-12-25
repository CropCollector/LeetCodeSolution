package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Java：子集 II
public class SubsetsIi {
    public static void main(String[] args) {
        Solution solution = new SubsetsIi().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private List<List<Integer>> ans = new ArrayList<>();

        public List<List<Integer>> subsetsWithDup(int[] nums) {
            Arrays.sort(nums);
            dfs(nums, nums.length, new ArrayList<>(), 0);
            return ans;
        }

        private void dfs(int[] nums, int len, ArrayList<Integer> arr, int index) {
            ans.add((List<Integer>) arr.clone());
            for (int i = index; i < len; i++) {
                if (i > index && nums[i] == nums[i - 1]) {
                    continue;
                }
                arr.add(nums[i]);
                dfs(nums, len, arr, i + 1);
                arr.remove((Object) nums[i]);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}