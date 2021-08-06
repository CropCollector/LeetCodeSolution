package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Queue;

//Java：访问所有节点的最短路径
public class ShortestPathVisitingAllNodes {
    public static void main(String[] args) {
        Solution solution = new ShortestPathVisitingAllNodes().new Solution();
        // TO TEST
        solution.shortestPathLength(new int[][]{{1,2,3},{0},{0},{0}});
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int shortestPathLength(int[][] graph) {
        int len = graph.length;
        Queue<Integer[]> q = new ArrayDeque<>();
        boolean[][] flag = new boolean[len][1 << len];
        for (int i = 0; i < len; i++) {
            q.add(new Integer[]{i, 1 << i, 0});
        }

        int ans = 0;
        while (!q.isEmpty()) {
            Integer[] tuple = q.poll();
            int cur = tuple[0], status = tuple[1], dist = tuple[2];
            if (flag[cur][status]) {
                continue;
            }
            flag[cur][status] = true;
            if (status == (1 << len) - 1) {
                ans = dist;
                break;
            }
            for (int i = 0; i < graph[cur].length; i++) {
                q.add(new Integer[]{graph[cur][i], status | 1 << graph[cur][i], dist + 1});
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}