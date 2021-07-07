package leetcode.editor.cn;

import java.util.*;

//Java：公交路线
public class BusRoutes {
    public static void main(String[] args) {
        Solution solution = new BusRoutes().new Solution();
        // TO TEST
        System.out.println(solution.numBusesToDestination(new int[][]{{1,7},{3,5}}, 5, 5));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) {
            return 0;
        }
        HashMap<Integer, Integer> stepMap = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();
        // 构造图, key是站台的编号，site是通过该站台的路线编号的集合
        Map<Integer, HashSet<Integer>> graph = new HashMap<>();
        // O(n ^ 2)
        for (int i = 0; i < routes.length; i++) {
            for (int j = 0; j < routes[i].length; j++) {
                HashSet<Integer> site = graph.getOrDefault(routes[i][j], new HashSet<>());
                site.add(i);
                graph.put(routes[i][j], site);
                // 是起点就把路线入栈
                if (routes[i][j] == source) {
                    q.add(i);
                    stepMap.put(i, 1);
                }
            }
        }

        while (!q.isEmpty()) {
            Integer lineNum = q.poll();
            for (int i = 0; i < routes[lineNum].length; i++) {
                if (routes[lineNum][i] == target) {
                    return stepMap.get(lineNum);
                }
                HashSet<Integer> nextLines = graph.get(routes[lineNum][i]);
                for (Integer nextLineNum : nextLines) {
                    if (!stepMap.containsKey(nextLineNum)) {
                        q.add(nextLineNum);
                        stepMap.put(nextLineNum, stepMap.get(lineNum) + 1);
                    }
                }
            }
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}