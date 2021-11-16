package leetcode.editor.cn;

import java.util.*;

//Java：三数之和
public class ThreeSum {
    public static void main(String[] args) {
        Solution solution = new ThreeSum().new Solution();
        // TO TEST
        System.out.println(solution.threeSum(new int[]{-1,0,1,2,-1,-4}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            int len = nums.length;
            List<List<Integer>> ans = new ArrayList<>();
            for (int i = 0; i < len - 2; i++) {
                if (i != 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                int a = nums[i];
                int l = i + 1, r = len - 1;
                while (l < r) {
                    int b = nums[l], c = nums[r], target = -a;
                    if (b + c > target) {
                        r --;
                    } else if (b + c < target) {
                        l ++;
                    } else {
                        List<Integer> list = new ArrayList<>();
                        list.add(a);
                        list.add(b);
                        list.add(c);
                        ans.add(list);
                        while (l < r && nums[l + 1] == nums[l]) {
                            l ++;
                        }
                        while (l < r && nums[r - 1] == nums[r]) {
                            r --;
                        }
                        l ++;
                        r --;
                    }
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}