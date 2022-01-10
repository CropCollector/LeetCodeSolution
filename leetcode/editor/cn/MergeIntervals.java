package leetcode.editor.cn;

import java.util.*;

//Java：合并区间
public class MergeIntervals {
    public static void main(String[] args) {
        Solution solution = new MergeIntervals().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] merge(int[][] intervals) {
            Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
            Stack<int[]> stack = new Stack<>();
            stack.add(intervals[0]);
            int len = intervals.length;
            for (int i = 1; i < len; i++) {
                int[] cur = intervals[i];
                int[] prev = stack.pop();
                if (prev[1] >= cur[0]) {
                    stack.add(new int[]{prev[0], Math.max(prev[1], cur[1])});
                } else {
                    stack.add(prev);
                    stack.add(cur);
                }
            }

            int[][] ans = new int[stack.size()][2];
            int i = stack.size() - 1;
            while (!stack.isEmpty()) {
                ans[i --] = stack.pop();
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}