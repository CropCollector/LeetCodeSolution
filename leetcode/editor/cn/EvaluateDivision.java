package leetcode.editor.cn;

import java.util.*;

//Java：除法求值
public class EvaluateDivision {
    public static void main(String[] args) {
        Solution solution = new EvaluateDivision().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
            Map<String, List<String>> graph = new HashMap<>();
            Map<String, Double> line = new HashMap<>();

            int len = equations.size();
            for (int i = 0; i < len; i++) {
                List<String> equation = equations.get(i);
                String start = equation.get(0), end = equation.get(1);

                // 正向
                List<String> list = graph.getOrDefault(start, new ArrayList<>());
                list.add(end);
                graph.put(start, list);
                line.put(start + " " + end, values[i]);

                // 反向
                list = graph.getOrDefault(end, new ArrayList<>());
                list.add(start);
                graph.put(end, list);
                line.put(end + " " + start, 1 / values[i]);
            }

            int qLen = queries.size();
            double[] ans = new double[qLen];
            for (int i = 0; i < qLen; i++) {
                List<String> query = queries.get(i);
                String start = query.get(0), end = query.get(1);
                ans[i] = dfs(graph, line, start, end, 1d, new HashSet<>());
            }
            return ans;
        }

        private double dfs(Map<String, List<String>> graph, Map<String, Double> line,
                           String cur, String end, double value, Set<String> flag) {
            if (!graph.containsKey(cur)) {
                return -1d;
            }
            if (cur.equals(end)) {
                return value;
            }
            if (flag.contains(cur)) {
                return -1d;
            }
            flag.add(cur);
            List<String> next = graph.get(cur);
            for (String s : next) {
                double result = dfs(graph, line, s, end, value * line.get(cur + " " + s), flag);
                if (result != -1) {
                    return result;
                }
            }
            flag.remove(cur);
            return -1d;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}