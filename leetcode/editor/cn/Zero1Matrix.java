package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

//Java：01 矩阵
public class Zero1Matrix {
    public static void main(String[] args) {
        Solution solution = new Zero1Matrix().new Solution();
        // TO TEST
        System.out.println(solution.updateMatrix(new int[][]{{0,0,0},{0,1,0},{1,1,1}}));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    class Point {
        int x;
        int y;
        int value;

        public Point(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        Queue<Point> q = new ArrayDeque<>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 0) {
                    q.add(new Point(i, j, mat[i][j]));
                } else {
                    mat[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        while (!q.isEmpty()) {
            Point p = q.poll();
            int x = p.x;
            int y = p.y;
            int step = p.value + 1;
            if (x > 0) {
                if (step < mat[x - 1][y]) {
                    mat[x - 1][y] = step;
                    q.add(new Point(x - 1, y, step));
                }
            }
            if (x < mat.length - 1) {
                if (step < mat[x + 1][y]) {
                    mat[x + 1][y] = step;
                    q.add(new Point(x + 1, y, step));
                }
            }
            if (y > 0) {
                if (step < mat[x][y - 1]) {
                    mat[x][y - 1] = step;
                    q.add(new Point(x, y - 1, step));
                }
            }
            if (y < mat[x].length - 1) {
                if (step < mat[x][y + 1]) {
                    mat[x][y + 1] = step;
                    q.add(new Point(x, y + 1, step));
                }
            }
        }
        return mat;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}