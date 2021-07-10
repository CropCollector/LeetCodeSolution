package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

//Java：和相同的二元子数组
public class BinarySubarraysWithSum {
    public static void main(String[] args) {
        Solution solution = new BinarySubarraysWithSum().new Solution();
        // TO TEST
        System.out.println(solution.numSubarraysWithSum(new int[]{1,0,1,0,1}, 2));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int[] sums = new int[nums.length];
        sums[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sums[i] = sums[i - 1] + nums[i];
        }

        int count = 0;
        Map<Integer, Integer> subMap = new HashMap<>();
        subMap.put(0, 1);
        for (int i = 0; i < sums.length; i++) {
            count += subMap.getOrDefault(sums[i] - goal, 0);
            subMap.put(sums[i], subMap.getOrDefault(sums[i], 0) + 1);
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}