package leetcode.editor.cn;

import java.util.*;

//Java：滑动谜题
public class SlidingPuzzle {
    public static void main(String[] args) {
        Solution solution = new SlidingPuzzle().new Solution();
        // TO TEST
        int[][] target = {{1, 2, 3}, {4, 0, 5}};
        System.out.println(solution.slidingPuzzle(target));
        /*for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.println(String.format("i: %s, j: %s, value: %s", i, j, target[i][j]));
            }
        }*/
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    class Bean {
        int[][] value;
        Integer step;

        Bean(int[][] value, Integer step) {
            this.value = value;
            this.step = step;
        }
    }

    public int slidingPuzzle(int[][] board) {
        int[][] target = {{1, 2, 3}, {4, 5, 0}};
        Map<String, Boolean> flag = new HashMap<>();
        Integer result = -1;

        Queue<Bean> q = new LinkedList<>();
        q.add(new Bean(board, 0));

        while (!q.isEmpty()) {
            Bean bean = q.poll();
            int[][] value = bean.value;
            Integer step = bean.step;

            flag.put(getStringFromIntArray(value), true);
            if (getStringFromIntArray(value).equals(getStringFromIntArray(target))) {
                result = step;
                break;
            }

            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 3; j++) {
                    if (value[i][j] == 0) {
                        if (j - 1 >= 0) {
                            int[][] moved = this.swap(value, new int[]{i, j}, new int[]{i, j - 1});
                            if (flag.get(getStringFromIntArray(moved)) == null) {
                                q.add(new Bean(moved, step + 1));
                            }
                        }
                        if (j + 1 < 3) {
                            int[][] moved = this.swap(value, new int[]{i, j}, new int[]{i, j + 1});
                            if (flag.get(getStringFromIntArray(moved)) == null) {
                                q.add(new Bean(moved, step + 1));
                            }
                        }
                        if (i - 1 == 0) {
                            int[][] moved = this.swap(value, new int[]{i, j}, new int[]{i - 1, j});
                            if (flag.get(getStringFromIntArray(moved)) == null) {
                                q.add(new Bean(moved, step + 1));
                            }
                        } else {
                            int[][] moved = this.swap(value, new int[]{i, j}, new int[]{i + 1, j});
                            if (flag.get(getStringFromIntArray(moved)) == null) {
                                q.add(new Bean(moved, step + 1));
                            }
                        }
                        break;
                    }
                }
            }

        }
        return result;
    }

        private int[][] swap(int[][] arr, int[] p1, int[] p2) {
            int[][] result = clone(arr);
            int tmp = result[p1[0]][p1[1]];
            result[p1[0]][p1[1]] = result[p2[0]][p2[1]];
            result[p2[0]][p2[1]] = tmp;
            return result;
        }

        private int[][] clone(int[][] arr) {
            int[][] result = new int[arr.length][arr[0].length];
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[0].length; j++) {
                    result[i][j] = arr[i][j];
                }
            }
            return result;
        }

        private String getStringFromIntArray(int[][] arr) {
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < arr.length; i ++) {
                for (int j = 0; j < arr[0].length; j++) {
                    sb.append(arr[i][j]);
                }
            }
            return sb.toString();
        }

}
//leetcode submit region end(Prohibit modification and deletion)

}