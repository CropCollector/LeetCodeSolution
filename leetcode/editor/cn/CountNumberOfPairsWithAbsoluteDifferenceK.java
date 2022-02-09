package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

//Java：差的绝对值为 K 的数对数目
public class CountNumberOfPairsWithAbsoluteDifferenceK {
    public static void main(String[] args) {
        Solution solution = new CountNumberOfPairsWithAbsoluteDifferenceK().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countKDifference(int[] nums, int k) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int num : nums) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }

            int ans = 0;
            for (Integer key : map.keySet()) {
                if (map.containsKey(key + k)) {
                    ans += map.get(key) * map.get(key + k);
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}