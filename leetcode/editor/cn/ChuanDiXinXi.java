package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Queue;

//Java：传递信息
public class ChuanDiXinXi {
    public static void main(String[] args) {
        Solution solution = new ChuanDiXinXi().new Solution();
        // TO TEST
        System.out.println(solution.numWays(5, new int[][]{{0,2},{2,1},{3,4},{2,3},{1,4},{2,0},{0,4}}, 3));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int numWays(int n, int[][] relation, int k) {
        // 建图
        HashMap<Integer, HashSet<Integer>> graph = new HashMap<>();
        for (int i = 0; i < relation.length; i++) {
            for (int j = 0; j < 1; j++) {
                HashSet<Integer> set = graph.getOrDefault(relation[i][0], new HashSet<>());
                set.add(relation[i][1]);
                graph.put(relation[i][0], set);
            }
        }
        return bfs(graph, n - 1, k);
    }

    class Bean {
        Integer i;
        Integer step;

        public Bean(Integer i, Integer step) {
            this.i = i;
            this.step = step;
        }
    }


    int bfs(HashMap<Integer, HashSet<Integer>> graph, int n, int k) {
        int count = 0;
        Queue<Bean> q = new ArrayDeque<>();
        q.add(new Bean(0, 0));
        while (!q.isEmpty()) {
            Bean b = q.poll();
            Integer cur = b.i;
            Integer step = b.step;
            if (b.step == k) {
                if (cur == n) {
                    count ++;
                }
                continue;
            }
            HashSet<Integer> nextList = graph.get(cur);
            if (nextList != null) {
                for (Integer next : nextList) {
                    q.add(new Bean(next, step + 1));
                }
            }
        }
        return count;
    }


}
//leetcode submit region end(Prohibit modification and deletion)

}