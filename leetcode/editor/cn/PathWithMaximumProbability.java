package leetcode.editor.cn;


import java.util.*;

//Java：概率最大的路径
public class PathWithMaximumProbability {
    public static void main(String[] args) {
        Solution solution = new PathWithMaximumProbability().new Solution();
        // TO TEST
        System.out.println(solution.maxProbability(3, new int[][]{{0, 1}}, new double[]{0.5}, 0, 2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
            // 建图
            Map<Integer, Map<Integer, Double>> graph = new HashMap<>();
            for (int i = 0; i < edges.length; i++) {
                int s = edges[i][0], e = edges[i][1];
                Map<Integer, Double> lines = graph.getOrDefault(s, new HashMap<>());
                lines.put(e, succProb[i]);
                graph.put(s, lines);

                lines = graph.getOrDefault(e, new HashMap<>());
                lines.put(s, succProb[i]);
                graph.put(e, lines);
            }

            // arr[i] 表示i到start节点的最大概率，初始都为0;
            double[] arr = new double[n];
            arr[start] = 1;

            PriorityQueue<double[]> pq = new PriorityQueue<>((o1, o2) -> o2[1] > o1[1] ? 1 : 0);
            pq.add(new double[]{arr[start], start});
            while (!pq.isEmpty()) {
                double[] next = pq.poll();
                double max = next[0];
                int index = (int) next[1];
                if (arr[index] != max) {
                    // 不一致 过期数据
                    continue;
                }
                if (graph.containsKey(index)) {
                    Map<Integer, Double> lines = graph.get(index);
                    for (Integer line : lines.keySet()) {
                        if (arr[index] * lines.get(line) > arr[line]) {
                            arr[line] = arr[index] * lines.get(line);
                            pq.add(new double[]{arr[line], line});
                        }
                    }
                }
            }
            return arr[end];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}