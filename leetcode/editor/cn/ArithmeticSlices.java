package leetcode.editor.cn;

//Java：等差数列划分
public class ArithmeticSlices {
    public static void main(String[] args) {
        Solution solution = new ArithmeticSlices().new Solution();
        // TO TEST
        System.out.println(solution.numberOfArithmeticSlices(new int[]{1,2,3,8,9,10}));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if (nums.length < 3) {
            return 0;
        }
        int ans = 0;
        for (int start = 0, end = start + 1; end + 1 < nums.length; start = end, end = start + 1) {
            int n1 = nums[start], n2 = nums[end], n3 = nums[end + 1];
            while ((n2 - n1) == (n3 - n2)) {
                end ++;
                if (end + 1 >= nums.length) {
                    break;
                }
                n1 = nums[end - 1];
                n2 = nums[end];
                n3 = nums[end + 1];
            }
            if (end != start + 1) {
                int len = end - start + 1;
                ans += (len - 1) * (len - 2) / 2; // 3 - 1 | 4 - 3 | 5 - 6 | 6 - 10
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}