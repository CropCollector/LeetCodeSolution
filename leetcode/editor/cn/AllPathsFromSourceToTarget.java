package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：所有可能的路径
public class AllPathsFromSourceToTarget {
    public static void main(String[] args) {
        Solution solution = new AllPathsFromSourceToTarget().new Solution();
        // TO TEST
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        dfs(graph, new ArrayList<Integer>(), 0);
        return ans;
    }

    private void dfs(int[][] graph, ArrayList<Integer> path, int i) {
        path.add(i);
        if (i == graph.length - 1) {
            ans.add(path);
            return;
        }
        for (int j = 0; j < graph[i].length; j++) {
            ArrayList<Integer> arr = new ArrayList<>();
            arr.addAll(path);
            dfs(graph, arr, graph[i][j]);
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}