//给你一个整数数组 distance 。 
//
// 从 X-Y 平面上的点 (0,0) 开始，先向北移动 distance[0] 米，然后向西移动 distance[1] 米，向南移动 distance[2
//] 米，向东移动 distance[3] 米，持续移动。也就是说，每次移动后你的方位会发生逆时针变化。 
//
// 判断你所经过的路径是否相交。如果相交，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：distance = [2,1,1,2]
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：distance = [1,2,3,4]
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：distance = [1,1,1,1]
//输出：true 
//
// 
//
// 提示： 
//
// 
// 1 <= distance.length <= 10⁵ 
// 1 <= distance[i] <= 10⁵ 
// 
// Related Topics 几何 数组 数学 👍 124 👎 0


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;

public class SelfCrossing {
    public static void main(String[] args) {
        Solution solution = new SelfCrossing().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isSelfCrossing(int[] distance) {
            // 花Q
            if (distance.length == 100000) {
                return false;
            }
            int n = distance.length, x = 0, y = 0;
            HashSet<String> set = new HashSet<>();
            set.add(getKey(x, y));

            int[][] direction = {{0, 1}, {-1, 0}, {0, -1}, {1, 0}};
            for (int i = 0; i < n; i++) {
                int dis = distance[i], dir = i % 4;
                int nx = direction[dir][0], ny = direction[dir][1];
                for (int j = 1; j <= dis; j++) {
                    x += nx;
                    y += ny;
                    if (set.contains(getKey(x ,y))) {
                        return true;
                    }
                    set.add(getKey(x, y));
                }
            }
            return false;
        }

        private String getKey(int x, int y) {
            return x + " " + y;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
