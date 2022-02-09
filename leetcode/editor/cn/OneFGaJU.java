package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Java：数组中和为 0 的三个数
public class OneFGaJU {
    public static void main(String[] args) {
        Solution solution = new OneFGaJU().new Solution();
        // TO TEST
        System.out.println(solution.threeSum(new int[]{-1,0,1,2,-1,-4}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> ans = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                if (i != 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                int l = i + 1, r = nums.length - 1;
                while (l < r) {
                    int sum = nums[i] + nums[l] + nums[r];
                    if (sum == 0) {
                        ans.add(Arrays.asList(nums[i], nums[l], nums[r]));
                        while (l < r && nums[++ l] == nums[l - 1]) {}
                    } else if (sum < 0) {
                        l ++;
                    } else {
                        r --;
                    }
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}