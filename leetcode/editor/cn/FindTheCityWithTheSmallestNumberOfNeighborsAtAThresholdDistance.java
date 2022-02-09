package leetcode.editor.cn;

import java.util.*;

//Java：阈值距离内邻居最少的城市
public class FindTheCityWithTheSmallestNumberOfNeighborsAtAThresholdDistance {
    public static void main(String[] args) {
        Solution solution = new FindTheCityWithTheSmallestNumberOfNeighborsAtAThresholdDistance().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findTheCity(int n, int[][] edges, int distanceThreshold) {
            Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
            for (int[] edge : edges) {
                int start = edge[0], end = edge[1], dis = edge[2];
                graph.computeIfAbsent(start, k -> new HashMap<>()).put(end, dis);
                graph.computeIfAbsent(end, k -> new HashMap<>()).put(start, dis);
            }

            int[][] arr = new int[n][n];
            for (int i = 0; i < n; i++) {
                // dijkstra
                Arrays.fill(arr[i], Integer.MAX_VALUE);
                arr[i][i] = 0;
                PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
                pq.add(new int[]{arr[i][i], i});
                while (!pq.isEmpty()) {
                    int[] pair = pq.poll();
                    int dis = pair[0], index = pair[1];
                    if (arr[i][index] != dis) {
                        continue;
                    }
                    if (dis > distanceThreshold) {
                        break;
                    }
                    if (!graph.containsKey(index)) {
                        continue;
                    }
                    Map<Integer, Integer> lines = graph.get(index);
                    for (Integer end : lines.keySet()) {
                        if (arr[i][index] + lines.get(end) < arr[i][end]) {
                            arr[i][end] = arr[i][index] + lines.get(end);
                            pq.add(new int[]{arr[i][end], end});
                        }
                    }
                }
            }

            int ans = -1, count = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                int tmp = 0;
                for (int j = 0; j < n; j++) {
                    if (arr[i][j] <= distanceThreshold) {
                        tmp ++;
                    }
                }
                if (tmp <= count) {
                    count = tmp;
                    ans = i;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}