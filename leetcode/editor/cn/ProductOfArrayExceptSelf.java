package leetcode.editor.cn;

//Java：除自身以外数组的乘积
public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        Solution solution = new ProductOfArrayExceptSelf().new Solution();
        // TO TEST
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        left[0] = nums[0];
        for (int i = 1; i < nums.length - 1; i++) {
            left[i] = left[i - 1] * nums[i];
        }

        right[nums.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 2; i > 0; i --) {
            right[i] = right[i + 1] * nums[i];
        }

        int[] ans = new int[nums.length];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = (i - 1 < 0 ? 1 : left[i - 1]) * (i + 1 == ans.length ? 1 : right[i + 1]);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}