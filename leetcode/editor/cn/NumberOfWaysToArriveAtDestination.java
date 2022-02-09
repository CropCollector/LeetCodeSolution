package leetcode.editor.cn;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

//Java：到达目的地的方案数
public class NumberOfWaysToArriveAtDestination {
    public static void main(String[] args) {
        Solution solution = new NumberOfWaysToArriveAtDestination().new Solution();
        // TO TEST
        System.out.println(solution.countPaths(7 , new int[][]{{0,6,7},{0,1,2},{1,2,3},{1,3,3},{6,3,3},{3,5,1},{6,5,1},{2,5,1},{0,4,5},{4,6,2}}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countPaths(int n, int[][] roads) {
            int MOD = (int) (1e9 + 7);

            Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
            for (int[] road : roads) {
                int start = road[0], end = road[1], cost = road[2];
                graph.computeIfAbsent(start, k -> new HashMap<>()).put(end, cost);
                graph.computeIfAbsent(end, k -> new HashMap<>()).put(start, cost);
            }

            PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(o -> o[0]));
            // dp[i][0] 表示0到i的最短花费时间 dp[i][1] 表示最短花费时间的方案数
            long[][] dp = new long[n][2];
            for (int i = 0; i < n; i++) {
                dp[i] = new long[]{Long.MAX_VALUE, 0};
            }
            dp[0] = new long[]{0, 1};
            pq.add(new long[]{dp[0][0], 0});
            
            while (!pq.isEmpty()) {
                long[] arr = pq.poll();
                long cost = arr[0];
                int index = (int) arr[1];
                if (dp[index][0] != cost) {
                    continue;
                }
                if (!graph.containsKey(index)) {
                    continue;
                }
                Map<Integer, Integer> lines = graph.get(index);
                for (Integer end : lines.keySet()) {
                    if (dp[index][0] + lines.get(end) < dp[end][0]) {
                        dp[end] = new long[]{dp[index][0] + lines.get(end) , dp[index][1]};
                        pq.add(new long[]{dp[end][0], end});
                    } else if (dp[index][0] + lines.get(end) == dp[end][0]) {
                        dp[end][1] = (dp[end][1] + dp[index][1]) % MOD;
                    }
                }
            }
            return (int) dp[n - 1][1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}