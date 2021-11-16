package leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;

//Java：最长连续序列
public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        Solution solution = new LongestConsecutiveSequence().new Solution();
        // TO TEST
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (Integer i : nums) {
            set.add(i);
        }
        int ans = 0;
        for (Integer i : set) {
            if (!set.contains(i - 1)) {
                int tmp = i, count = 1;
                while (set.contains(tmp + 1)) {
                    tmp ++;
                    count ++;
                }
                ans = Math.max(count, ans);
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}