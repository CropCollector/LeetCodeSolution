package leetcode.editor.cn;

//Java：丢失的数字
public class MissingNumber {
    public static void main(String[] args) {
        Solution solution = new MissingNumber().new Solution();
        // TO TEST
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sum = (1 + n) * n / 2;
        for (int num : nums) {
            sum -= num;
        }
        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}