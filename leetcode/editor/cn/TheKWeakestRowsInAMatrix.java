package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

//Java：矩阵中战斗力最弱的 K 行
public class TheKWeakestRowsInAMatrix {
    public static void main(String[] args) {
        Solution solution = new TheKWeakestRowsInAMatrix().new Solution();
        // TO TEST
        solution.kWeakestRows(new int[][]{{1,1,0,0,0},{1,1,1,1,0},{1,0,0,0,0},{1,1,0,0,0},{1,1,1,1,1}}, 3);
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    class Bean implements Comparable{
        int sum;
        int row;

        public Bean(int sum, int row) {
            this.sum = sum;
            this.row = row;
        }

        @Override
        public int compareTo(Object o) {
            Bean bean = (Bean) o;
            if (this.sum > bean.sum) {
                return 1;
            } else if (this.sum == bean.sum) {
                return this.row > bean.row ? 1 : -1;
            } else {
                return -1;
            }
        }
    }

    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<Bean> pq = new PriorityQueue<>();
        for (int i = 0; i < mat.length; i++) {
            int sum = 0;
            for (int j = 0; j < mat[i].length; j++) {
                sum += mat[i][j];
            }
            pq.add(new Bean(sum, i));
        }
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = pq.poll().row;
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}