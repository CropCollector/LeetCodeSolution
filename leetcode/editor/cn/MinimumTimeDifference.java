package leetcode.editor.cn;

import java.util.Collections;
import java.util.List;

//Java：最小时间差
public class MinimumTimeDifference {
    public static void main(String[] args) {
        Solution solution = new MinimumTimeDifference().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findMinDifference(List<String> timePoints) {
            if (timePoints.size() > 1440) {
                return 0;
            }
            Collections.sort(timePoints, (s1, s2) -> {
                String[] t1 = s1.split(":"), t2 = s2.split(":");
                int h1 = Integer.valueOf(t1[0]), m1 = Integer.valueOf(t1[1]), h2 = Integer.valueOf(t2[0]), m2 = Integer.valueOf(t2[1]);
                return h1 != h2 ? h1 - h2 : m1 - m2;
            });

            int ans = Integer.MAX_VALUE, len = timePoints.size();
            for (int i = 0; i < len; i++) {
                String s1 = timePoints.get(i);
                int minutes = 0;
                if (i == 0) {
                    String s2 = timePoints.get(len - 1);
                    String[] t1 = s1.split(":"), t2 = s2.split(":");
                    int h1 = Integer.valueOf(t1[0]) + 24, m1 = Integer.valueOf(t1[1]), h2 = Integer.valueOf(t2[0]), m2 = Integer.valueOf(t2[1]);
                    minutes = (h1 - h2) * 60 + m1 - m2;
                } else {
                    String s2 = timePoints.get(i - 1);
                    String[] t1 = s1.split(":"), t2 = s2.split(":");
                    int h1 = Integer.valueOf(t1[0]), m1 = Integer.valueOf(t1[1]), h2 = Integer.valueOf(t2[0]), m2 = Integer.valueOf(t2[1]);
                    minutes = (h1 - h2) * 60 + m1 - m2;
                }
                ans = Math.min(ans, minutes);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}