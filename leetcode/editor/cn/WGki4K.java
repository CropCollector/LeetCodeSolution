package leetcode.editor.cn;

//Java：只出现一次的数字
public class WGki4K {
    public static void main(String[] args) {
        Solution solution = new WGki4K().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int singleNumber(int[] nums) {
            int[] ansBit = new int[32];
            for (int i = 0; i <= 31; i++) {
                int bit = 0;
                for (int num : nums) {
                    bit += ((num >> i) & 1);
                }
                ansBit[i] = bit % 3;
            }
            int ans = 0;
            for (int i = 0; i <= 31; i++) {
                ans += (1 << i) * ansBit[i];
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}