package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

//Java：地图中的最高点
public class MapOfHighestPeak {
    public static void main(String[] args) {
        Solution solution = new MapOfHighestPeak().new Solution();
        // TO TEST
        System.out.println(solution.highestPeak(new int[][]{{0,0,1},{1,0,0},{0,0,0}}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] highestPeak(int[][] isWater) {
            int m = isWater.length, n = isWater[0].length;
            int[][] ans = new int[m][n];
            for (int[] an : ans) {
                Arrays.fill(an, -1);
            }

            Queue<int[]> q = new ArrayDeque<>();
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (isWater[i][j] == 1) {
                        q.add(new int[]{i, j, 0});
                    }
                }
            }
            while (!q.isEmpty()) {
                int[] pairs = q.poll();
                int x = pairs[0], y = pairs[1], height = pairs[2];
                if (x < 0 || x == m || y < 0 || y == n) {
                    continue;
                }
                if (ans[x][y] != -1) {
                    continue;
                }
                ans[x][y] = height;
                height ++;
                q.add(new int[]{x + 1, y, height});
                q.add(new int[]{x - 1, y, height});
                q.add(new int[]{x, y + 1, height});
                q.add(new int[]{x, y - 1, height});
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}