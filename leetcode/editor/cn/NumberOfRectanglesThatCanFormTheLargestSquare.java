package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

//Java：可以形成最大正方形的矩形数目
public class NumberOfRectanglesThatCanFormTheLargestSquare {
    public static void main(String[] args) {
        Solution solution = new NumberOfRectanglesThatCanFormTheLargestSquare().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countGoodRectangles(int[][] rectangles) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int[] rectangle : rectangles) {
                int l = Math.min(rectangle[0], rectangle[1]);
                map.put(l, map.getOrDefault(l, 0) + 1);
            }
            int max = map.keySet().stream().sorted((n1, n2) -> n2 - n1).findFirst().get();
            return map.get(max);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}