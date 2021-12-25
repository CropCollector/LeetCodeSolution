//给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
//
// 你可以按 任何顺序 返回答案。
//
//
//
// 示例 1：
//
//
//输入：n = 4, k = 2
//输出：
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//]
//
// 示例 2：
//
//
//输入：n = 1, k = 1
//输出：[[1]]
//
//
//
// 提示：
//
//
// 1 <= n <= 20
// 1 <= k <= n
//
// Related Topics 数组 回溯 👍 778 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public static void main(String[] args) {
        Solution solution = new Combinations().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private int n;

        private int k;

        private List<List<Integer>> ans = new ArrayList<>();

        public List<List<Integer>> combine(int n, int k) {
            this.n = n;
            this.k = k;
            dfs(new ArrayList<>(), 1, 0);
            return ans;
        }

        private void dfs(ArrayList<Object> arr, int index, int cur) {
            if (cur == k) {
                ans.add((List<Integer>) arr.clone());
                return;
            }
            for (int i = index; i <= n; i++) {
                if (i + k - cur - 1 > n) {
                    break;
                }
                arr.add(i);
                dfs(arr, i + 1, cur + 1);
                arr.remove((Object) i);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
