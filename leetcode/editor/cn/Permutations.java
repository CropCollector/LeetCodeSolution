package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

//Java：全排列
public class Permutations {
    public static void main(String[] args) {
        Solution solution = new Permutations().new Solution();
        /*List<List<Integer>> ans = solution.permute(new int[]{1,2,3,4});
        for (List<Integer> an : ans) {
            System.out.println(an);
        }*/
        List<Integer> arr = Arrays.asList(1,2,3,4);
        Collections.swap(arr, 0 ,3);
        System.out.println(arr);
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private List<List<Integer>> ans = new ArrayList<>();

        private List<Integer> nums;

        private int len;

        public List<List<Integer>> permute(int[] nums) {
            Arrays.sort(nums);
            this.nums = Arrays.stream(nums).boxed().collect(Collectors.toList());
            this.len = nums.length;
            find(0);
            return ans;
        }

        private void find(int start) {
            if (start == len - 1) {
                ans.add(new ArrayList<>(nums));
                return;
            }
            for (int i = start; i < len; i++) {
                Collections.swap(nums, i, start);
                find(start + 1);
                Collections.swap(nums, i, start);
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}