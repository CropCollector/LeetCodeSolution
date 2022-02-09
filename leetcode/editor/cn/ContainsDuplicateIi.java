package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

//Java：存在重复元素 II
public class ContainsDuplicateIi {
    public static void main(String[] args) {
        Solution solution = new ContainsDuplicateIi().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean containsNearbyDuplicate(int[] nums, int k) {
            Map<Integer, Integer> map = new HashMap<>();
            int len = nums.length;
            for (int i = 0; i < len; i++) {
                if (map.containsKey(nums[i])) {
                    int prevIndex = map.get(nums[i]);
                    if (i - prevIndex <= k) {
                        return true;
                    }
                }
                map.put(nums[i], i);
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}