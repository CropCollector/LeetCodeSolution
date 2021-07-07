package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

//Java：大餐计数
public class CountGoodMeals {
    public static void main(String[] args) {
        Solution solution = new CountGoodMeals().new Solution();
        // TO TEST
        System.out.println(solution.countPairs(new int[]{1,3,5,7,9}));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countPairs(int[] deliciousness) {
        int mod = (int) (1e9 + 7);
        int max = 0;
        for (int i = 0; i < deliciousness.length; i++) {
            max = Math.max(max, deliciousness[i]);
        }
        max = max * 2;

        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < deliciousness.length; i++) {
            int cur = deliciousness[i];
            for (int sum = 1; sum <= max ; sum <<= 1) {
                int pair = map.getOrDefault(sum - cur, 0);
                count = (count + pair) % mod;
            }
            map.put(cur, map.getOrDefault(cur, 0) + 1);
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}