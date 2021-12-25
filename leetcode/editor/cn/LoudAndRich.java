package leetcode.editor.cn;

import java.util.*;

//Java：喧闹和富有
public class LoudAndRich {
    public static void main(String[] args) {
        Solution solution = new LoudAndRich().new Solution();
        // TO TEST
        System.out.println(solution.loudAndRich(new int[][]{{1,0},{2,1},{3,1},{3,7},{4,3},{5,3},{6,3}}, new int[]{3,2,5,4,6,1,7,0}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private int[] quiet;

        private Map<Integer, List<Integer>> graph = new HashMap<>();

        private int[] ans;

        public int[] loudAndRich(int[][] richer, int[] quiet) {
            this.quiet = quiet;
            int len = quiet.length;

            for (int[] ints : richer) {
                int rich = ints[0], poor = ints[1];
                List<Integer> list = graph.getOrDefault(poor, new ArrayList<>());
                list.add(rich);
                graph.put(poor, list);
            }

            this.ans = new int[len];
            Arrays.fill(ans, -1);
            for (int i = 0; i < len; i++) {
                dfs(i);
            }
            return ans;
        }

        private void dfs(int i) {
            if (ans[i] != -1) {
                return;
            }
            ans[i] = i;
            List<Integer> list = graph.get(i);
            if (list != null) {
                for (Integer nextI : list) {
                    dfs(nextI);
                    if (quiet[ans[nextI]] < quiet[ans[i]]) {
                        ans[i] = ans[nextI];
                    }
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}