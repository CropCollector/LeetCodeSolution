package leetcode.editor.cn;

import java.util.Optional;
import java.util.TreeSet;

//Java：供暖器
public class Heaters {
    public static void main(String[] args) {
        Solution solution = new Heaters().new Solution();
        // TO TEST
        System.out.println(solution.findRadius(new int[]{1,2,3,4}, new int[]{1,4}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findRadius(int[] houses, int[] heaters) {
            // 通过二分求出每个house离它最近的heat的距离，把得到的所有的距离取最大值即为所求的最小加热半径 时间o(nlogn) 空间o(n)
            int houseLen = houses.length;
            TreeSet<Integer> treeSet = new TreeSet<>();
            for (int heater : heaters) {
                treeSet.add(heater);
            }
            int maxSize = Integer.MIN_VALUE;
            for (int i = 0; i < houseLen; i++) {
                Integer floor = treeSet.floor(houses[i]);
                if (floor == null) {
                    floor = Integer.MAX_VALUE;
                }
                Integer ceiling = treeSet.ceiling(houses[i]);
                if (ceiling == null) {
                    ceiling = Integer.MAX_VALUE;
                }
                maxSize = Math.max(maxSize, Math.min(Math.abs(floor - houses[i]), Math.abs(ceiling - houses[i])));
            }
            return maxSize;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}