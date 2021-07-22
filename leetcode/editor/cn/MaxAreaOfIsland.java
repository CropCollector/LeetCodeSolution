package leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;

//Java：岛屿的最大面积
public class MaxAreaOfIsland {
    public static void main(String[] args) {
        Solution solution = new MaxAreaOfIsland().new Solution();
        // TO TEST
        System.out.println(solution.maxAreaOfIsland(new int[][]{{0,0,1,0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,1,1,0,1,0,0,0,0,0,0,0,0},{0,1,0,0,1,1,0,0,1,0,1,0,0},{0,1,0,0,1,1,0,0,1,1,1,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0}}));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        HashSet<String> points = new HashSet<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1)
                    points.add(getKey(i, j));
            }
        }

        int maxArea = 0;
        while (!points.isEmpty()) {
            String[] point = points.iterator().next().split(" ");
            int i = Integer.parseInt(point[0]);
            int j = Integer.parseInt(point[1]);
            int area = dfs(grid, points, i, j);
            maxArea = Math.max(area, maxArea);
        }
        return maxArea;
    }

    public int dfs(int[][] grid, HashSet<String> points, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length) {
            return 0;
        }
        String key = getKey(i, j);
        if (!points.contains(key)) {
            return 0;
        } else {
            points.remove(key);
        }
        int sum = 1;
        if (i > 0) {
            sum += dfs(grid, points, i - 1, j);
        }
        if (i < grid.length - 1) {
            sum += dfs(grid, points, i + 1, j);
        }
        if (j > 0) {
            sum += dfs(grid, points, i, j - 1);
        }
        if (j < grid[i].length + 1) {
            sum += dfs(grid, points, i, j + 1);
        }
        return sum;
    }

    private String getKey(int i, int j) {
        return  i + " " + j;
    }
}

}
//leetcode submit region end(Prohibit modification and deletion)

