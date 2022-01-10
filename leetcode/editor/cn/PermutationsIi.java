package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

//Java：全排列 II
public class PermutationsIi {
    public static void main(String[] args) {
        Solution solution = new PermutationsIi().new Solution();
        // TO TEST
        System.out.println(solution.permuteUnique(new int[]{0,3,3,3}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private List<List<Integer>> ans = new ArrayList<>();

        private List<Integer> nums;

        private int len;

        public List<List<Integer>> permuteUnique(int[] nums) {
            Arrays.sort(nums);
            this.nums = Arrays.stream(nums).boxed().collect(Collectors.toList());
            this.len = nums.length;
            find(0);
            return ans;
        }

        private void find(int start) {
            if (start == len - 1) {
                //System.out.println(nums);
                ans.add(new ArrayList<>(nums));
                return;
            }
            for (int i = start; i < len; i++) {
                boolean skip = false;
                for (int j = i - 1; j >= start; j--) {
                    if (nums.get(i) == nums.get(j)) {
                        skip = true;
                        break;
                    }
                }
                if (skip) {
                    continue;
                }
                Collections.swap(nums, i, start);
                find(start + 1);
                Collections.swap(nums, i, start);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}