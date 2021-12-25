//给你一个炸弹列表。一个炸弹的 爆炸范围 定义为以炸弹为圆心的一个圆。 
//
// 炸弹用一个下标从 0 开始的二维整数数组 bombs 表示，其中 bombs[i] = [xi, yi, ri] 。xi 和 yi 表示第 i 个炸弹的 
//X 和 Y 坐标，ri 表示爆炸范围的 半径 。 
//
// 你需要选择引爆 一个 炸弹。当这个炸弹被引爆时，所有 在它爆炸范围内的炸弹都会被引爆，这些炸弹会进一步将它们爆炸范围内的其他炸弹引爆。 
//
// 给你数组 bombs ，请你返回在引爆 一个 炸弹的前提下，最多 能引爆的炸弹数目。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：bombs = [[2,1,3],[6,1,4]]
//输出：2
//解释：
//上图展示了 2 个炸弹的位置和爆炸范围。
//如果我们引爆左边的炸弹，右边的炸弹不会被影响。
//但如果我们引爆右边的炸弹，两个炸弹都会爆炸。
//所以最多能引爆的炸弹数目是 max(1, 2) = 2 。
// 
//
// 示例 2： 
//
// 
//
// 输入：bombs = [[1,1,5],[10,10,5]]
//输出：1
//解释：
//引爆任意一个炸弹都不会引爆另一个炸弹。所以最多能引爆的炸弹数目为 1 。
// 
//
// 示例 3： 
//
// 
//
// 输入：bombs = [[1,2,3],[2,3,1],[3,4,2],[4,5,3],[5,6,4]]
//输出：5
//解释：
//最佳引爆炸弹为炸弹 0 ，因为：
//- 炸弹 0 引爆炸弹 1 和 2 。红色圆表示炸弹 0 的爆炸范围。
//- 炸弹 2 引爆炸弹 3 。蓝色圆表示炸弹 2 的爆炸范围。
//- 炸弹 3 引爆炸弹 4 。绿色圆表示炸弹 3 的爆炸范围。
//所以总共有 5 个炸弹被引爆。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= bombs.length <= 100 
// bombs[i].length == 3 
// 1 <= xi, yi, ri <= 10⁵ 
// 
// 👍 2 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DetonateTheMaximumBombs {
    public static void main(String[] args) {
        Solution solution = new DetonateTheMaximumBombs().new Solution();
        System.out.println(solution.maximumDetonation(new int[][]{{1,1,5},{10,10,5}}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private Map<Integer, List<Integer>> graph = new HashMap<>();

        private boolean[] flag;

        public int maximumDetonation(int[][] bombs) {
            // 邻接表
            int len = bombs.length;
            flag = new boolean[len];

            for (int i = 0; i < len; i++) {
                int c1x = bombs[i][0], c1y = bombs[i][1], c1r = bombs[i][2];
                for (int j = i + 1; j < len; j++) {
                    int c2x = bombs[j][0], c2y = bombs[j][1], c2r = bombs[j][2];
                    double dis = Math.pow(c2x - c1x, 2) + Math.pow(c2y - c1y, 2);
                    if (dis <= Math.pow(c1r, 2)) {
                        List<Integer> list = graph.getOrDefault(i, new ArrayList<>());
                        list.add(j);
                        graph.put(i, list);
                    }
                    if (dis <= Math.pow(c2r, 2)) {
                        List<Integer> list = graph.getOrDefault(j, new ArrayList<>());
                        list.add(i);
                        graph.put(j, list);
                    }
                }
            }

            int ans = 1;
            for (Integer start : graph.keySet()) {
                ans = Math.max(ans, dfs(start));
                flag = new boolean[len];
            }
            return ans;
        }

        private int dfs(Integer node) {
            if (flag[node]) {
                return 0;
            }
            flag[node] = true;
            if (graph.get(node) == null) {
                return 1;
            }
            int sum = 1;
            List<Integer> list = graph.get(node);
            for (Integer nextNode : list) {
                sum += dfs(nextNode);
            }
            return sum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
