package leetcode.editor.cn;

import java.util.*;

//Java：到达目的地的第二短时间
public class SecondMinimumTimeToReachDestination {
    public static void main(String[] args) {
        Solution solution = new SecondMinimumTimeToReachDestination().new Solution();
        // TO TEST
        System.out.println(solution.secondMinimum(2, new int[][]{{1,2}}, 3, 2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int secondMinimum(int n, int[][] edges, int time, int change) {
            // 建图
            Map<Integer, HashSet<Integer>> graph = new HashMap<>();
            for (int[] edge : edges) {
                int start = edge[0], end = edge[1];
                HashSet<Integer> set = graph.getOrDefault(start, new HashSet<>());
                set.add(end);
                graph.put(start, set);

                set = graph.getOrDefault(end, new HashSet<>());
                set.add(start);
                graph.put(end, set);
            }

            int min = Integer.MAX_VALUE;
            int[] flag = new int[n + 1];
            Queue<int[]> q = new ArrayDeque<>();
            q.add(new int[]{1, 0});
            int level = 1, count = 1;
            while (!q.isEmpty()) {
                int nextCount = 0;
                for (int i = 1; i <= count; i++) {
                    int[] curNode = q.poll();
                    int node = curNode[0], sum = curNode[1];
                    if (flag[node] == -1) {
                        continue;
                    } else if (flag[node] == 0) {
                        flag[node] = level;
                    } else {
                        if (flag[node] != level) {
                            flag[node] = -1;
                        }
                    }
                    if (node == n) {
                        if (min == Integer.MAX_VALUE) {
                            min = sum;
                        } else {
                            if (sum != min) {
                                return sum;
                            }
                        }
                    }
                    // 若当前处于红灯,要加上等待的时间
                    if ((sum / change) % 2 == 1) {
                        sum += change - sum % change;
                    }
                    HashSet<Integer> lines = graph.get(node);
                    for (Integer line : lines) {
                        q.add(new int[]{line, sum + time});
                        nextCount ++;
                    }
                }
                count = nextCount;
                level ++;
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}