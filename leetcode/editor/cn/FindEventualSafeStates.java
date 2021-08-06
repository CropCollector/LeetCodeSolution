package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

//Java：找到最终的安全状态
public class FindEventualSafeStates {
    public static void main(String[] args) {
        Solution solution = new FindEventualSafeStates().new Solution();
        // TO TEST
        solution.eventualSafeNodes(new int[][]{{1,2},{2,3},{5},{0},{5},{},{}});
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    int[] flag;

    public List<Integer> eventualSafeNodes(int[][] graph) {
        flag = new int[graph.length];

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < graph.length; i++) {
            if (safe(i, graph)) ans.add(i);
        }
        return ans;
    }

    private boolean safe(int i, int[][] graph) {
        if (flag[i] != 0) {
            return flag[i] == 2;
        }
        flag[i] = 1;
        for (int next : graph[i]) {
            if (!safe(next, graph)) {
                return false;
            }
        }
        flag[i] = 2;
        return true;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}