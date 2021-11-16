package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

//Java：矩阵中的最长递增路径
public class LongestIncreasingPathInAMatrix {
    public static void main(String[] args) {
        Solution solution = new LongestIncreasingPathInAMatrix().new Solution();
        // TO TEST
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private Map<String, Integer> cache = new HashMap<>();

    private int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int longestIncreasingPath(int[][] matrix) {
        int ans = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                ans = Math.max(ans, dfs(matrix, i, j));
            }
        }
        return ans;
    }

    private int dfs(int[][] matrix, int i, int j) {
        if (cache.containsKey(key(i ,j))) {
            return cache.get(key(i, j));
        }
        int pathLen = 1;
        for (int k = 0; k < dir.length; k++) {
            int nextI = i + dir[k][0], nextJ = j + dir[k][1];
            if (nextI >= 0 && nextI < matrix.length && nextJ >= 0 && nextJ < matrix[nextI].length
            && matrix[nextI][nextJ] > matrix[i][j]) {
                pathLen = Math.max(pathLen, dfs(matrix, nextI, nextJ) + 1);
            }
        }
        pathLen = Math.max(cache.getOrDefault(key(i, j), 0), pathLen);
        cache.put(key(i, j), pathLen);
        return pathLen;
    }

    private String key(int i, int j) {
        return i + " " + j;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}