package leetcode.editor.cn;

import java.util.PriorityQueue;

//Java：接雨水 II
public class TrappingRainWaterIi {
    public static void main(String[] args) {
        Solution solution = new TrappingRainWaterIi().new Solution();
        // TO TEST
        System.out.println(solution.trapRainWater(new int[][]{{1,4,3,1,3,2},{3,2,1,3,2,4},{2,3,3,2,3,1}}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public class Block implements Comparable{
            int h;
            int x;
            int y;

            public Block(int h, int x, int y) {
                this.h = h;
                this.x = x;
                this.y = y;
            }

            @Override
            public int compareTo(Object o) {
                return this.h - ((Block) o).h;
            }
        }

        public int trapRainWater(int[][] heightMap) {
            int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
            int m = heightMap.length, n = heightMap[0].length;
            boolean[][] flag = new boolean[m][n];
            PriorityQueue<Block> pq = new PriorityQueue<>();
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
                        pq.add(new Block(heightMap[i][j], i, j));
                        flag[i][j] = true;
                    }
                }
            }
            int ans = 0;
            while (!pq.isEmpty()) {
                Block block = pq.poll();
                int x = block.x, y = block.y, h = block.h;
                for (int i = 0; i < dir.length; i++) {
                    int nx = x + dir[i][0], ny = y + dir[i][1];
                    if (nx < 0 || nx >= m || ny < 0 || ny >= n || flag[nx][ny]) {
                        continue;
                    }
                    ans += Math.max(block.h - heightMap[nx][ny], 0);
                    pq.add(new Block(Math.max(block.h, heightMap[nx][ny]), nx, ny));
                    flag[nx][ny] = true;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}