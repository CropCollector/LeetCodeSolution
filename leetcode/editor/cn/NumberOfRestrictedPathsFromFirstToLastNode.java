package leetcode.editor.cn;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

//Java：从第一个节点出发到最后一个节点的受限路径数
public class NumberOfRestrictedPathsFromFirstToLastNode {
    public static void main(String[] args) {
        Solution solution = new NumberOfRestrictedPathsFromFirstToLastNode().new Solution();
        // TO TEST
        System.out.println(solution.countRestrictedPaths(5, new int[][]{{1,2,3},{1,3,3},{2,3,1},{1,4,2},{5,2,2},{3,5,1},{5,4,10}}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countRestrictedPaths(int n, int[][] edges) {
            int MOD = (int) (1e9 + 7);
            Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
            for (int[] edge : edges) {
                int start = edge[0], end = edge[1], path = edge[2];
                graph.computeIfAbsent(start, k -> new HashMap<>()).put(end, path);
                graph.computeIfAbsent(end, k -> new HashMap<>()).put(start, path);
            }

            // dp[i][0] 表示n到i的最短路径长度 dp[i][1] 表示n到i的受限路径数
            int[][] dp = new int[n + 1][2];
            for (int i = 1; i <= n; i++) {
                dp[i] = new int[]{Integer.MAX_VALUE, 0};
            }
            dp[n] = new int[]{0, 1};

            PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
            pq.add(new int[]{dp[n][0], n});

            while (!pq.isEmpty()) {
                int[] pair = pq.poll();
                int path = pair[0], index = pair[1];
                if (dp[index][0] != path) {
                    continue;
                }
                if (!graph.containsKey(index)) {
                    continue;
                }
                Map<Integer, Integer> line = graph.get(index);
                for (Integer end : line.keySet()) {
                    // 当前节点到n的最短距离小于下一个节点到n的最短距离 那么把当前的节点的受限路径数加到下个节点的受限路径数上
                    if (dp[index][0] < dp[end][0]) {
                        dp[end][1] = (dp[end][1] + dp[index][1]) % MOD;
                    }
                    if (dp[index][0] + line.get(end) < dp[end][0]) {
                        dp[end][0] = dp[index][0] + line.get(end);
                        pq.add(new int[]{dp[end][0], end});
                    }
                }
            }
            return dp[1][1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}