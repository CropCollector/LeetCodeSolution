package leetcode.editor.cn;

import java.util.*;

//Java：从相邻元素对还原数组
public class RestoreTheArrayFromAdjacentPairs {
    public static void main(String[] args) {
        Solution solution = new RestoreTheArrayFromAdjacentPairs().new Solution();
        // TO TEST
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < adjacentPairs.length; i++) {
            int a = adjacentPairs[i][0];
            int b = adjacentPairs[i][1];
            map.putIfAbsent(a, new ArrayList<>());
            map.putIfAbsent(b, new ArrayList<>());
            map.get(a).add(b);
            map.get(b).add(a);
        }

        int n = adjacentPairs.length + 1;
        int[] ret = new int[n];
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            int e = entry.getKey();
            List<Integer> adj = entry.getValue();
            if (adj.size() == 1) {
                ret[0] = e;
                break;
            }
        }

        ret[1] = map.get(ret[0]).get(0);
        for (int i = 2; i < n; i++) {
            List<Integer> adj = map.get(ret[i - 1]);
            ret[i] = ret[i - 2] == adj.get(0) ? adj.get(1) : adj.get(0);
        }
        return ret;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}