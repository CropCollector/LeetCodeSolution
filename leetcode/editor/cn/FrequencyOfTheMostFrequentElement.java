package leetcode.editor.cn;

import java.util.Arrays;

//Java：最高频元素的频数
public class FrequencyOfTheMostFrequentElement {
    public static void main(String[] args) {
        Solution solution = new FrequencyOfTheMostFrequentElement().new Solution();
        // TO TEST
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int win = 0, l, r;
        for (l = 0, r = 1; r < nums.length; r ++) {
            win += (r - l) * (nums[r] - nums[r - 1]);
            if (win > k) {
                win -= (nums[r] - nums[l]);
                l ++;
            }
        }
        return r - l;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}