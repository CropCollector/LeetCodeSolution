package leetcode.editor.cn;

import java.util.HashSet;

//Java：环形数组是否存在循环
public class CircularArrayLoop {
    public static void main(String[] args) {
        Solution solution = new CircularArrayLoop().new Solution();
        // TO TEST
        System.out.println(solution.circularArrayLoop(new int[]{-2,-3,-9}));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean circularArrayLoop(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (checkCircle(nums, i)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkCircle(int[] nums, int i) {
        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();
        while (true) {
            set.add(i);
            int curStep = nums[i], nextI = (i + curStep + 1000 * n) % n, nextStep = nums[nextI];
            if (curStep * nextStep < 0 || i == nextI) {
                return false;
            }
            if (set.contains(nextI)) {
                return true;
            }
            i = nextI;
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}