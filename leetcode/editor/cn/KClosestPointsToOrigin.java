package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

//Java：最接近原点的 K 个点
public class KClosestPointsToOrigin {
    public static void main(String[] args) {
        Solution solution = new KClosestPointsToOrigin().new Solution();
        // TO TEST
        System.out.println(solution.kClosest(new int[][]{{0,1},{1,0}}, 1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] kClosest(int[][] points, int k) {
            quickSort(points, 0, points.length - 1, k);
            return Arrays.copyOf(points, k);
        }

        private void quickSort(int[][] points, int start, int end, int k) {
            if (start >= end) {
                return;
            }
            double base = getDis(points[start]);
            int l = start, r = end;
            while (l < r) {
                while (l < r && getDis(points[r]) >= base) {
                    r --;
                }
                while (l < r && getDis(points[l]) <= base) {
                    l ++;
                }
                swap(points, r, l);
            }
            swap(points, start, l);
            if (l == k) {
                return;
            } else if (l < k) {
                quickSort(points, l + 1, end, k);
            } else {
                quickSort(points, start, l - 1, k);
            }
        }

        private void swap(int[][] points, int i1, int i2) {
            int[] tmp = points[i1];
            points[i1] = points[i2];
            points[i2] = tmp;
        }

        private double getDis(int[] point) {
            return Math.pow(point[0], 2) + Math.pow(point[1], 2);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}