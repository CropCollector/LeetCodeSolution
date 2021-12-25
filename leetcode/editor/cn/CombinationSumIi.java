package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

//Java：组合总和 II
public class CombinationSumIi {
    public static void main(String[] args) {
        Solution solution = new CombinationSumIi().new Solution();
        // TO TEST
        HashSet<List<Integer>> set = new HashSet<>();
        set.add(Arrays.asList(1, 2, 3));
        set.add(Arrays.asList(1, 2, 3));
        System.out.println(set);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private int[] candidates;

        private int len;

        private int target;

        private List<List<Integer>> ans = new ArrayList<>();

        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            Arrays.sort(candidates);
            this.candidates = candidates;
            this.len = candidates.length;
            this.target = target;
            dfs(new ArrayList<Integer>(), 0, 0);
            return ans;
        }

        private void dfs(ArrayList<Integer> arr, int index, int sum) {
            if (sum == target) {
                List<Integer> cArr = (List<Integer>) arr.clone();
                ans.add(cArr);
                return;
            }
            for (int i = index; i < len; i++) {
                if (sum + candidates[i] > target) {
                    break;
                }
                if (i > index && candidates[i] == candidates[i - 1]) {
                    continue;
                }
                arr.add(candidates[i]);
                dfs(arr, i + 1, sum + candidates[i]);
                arr.remove((Object) candidates[i]);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}