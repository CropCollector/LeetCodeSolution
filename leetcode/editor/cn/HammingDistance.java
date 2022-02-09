package leetcode.editor.cn;

//Java：汉明距离
public class HammingDistance {
    public static void main(String[] args) {
        Solution solution = new HammingDistance().new Solution();
        // TO TEST
        System.out.println(solution.hammingDistance(1, 4));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int hammingDistance(int x, int y) {
            int ans = 0;
            while (x != 0 || y != 0) {
                if (((x & 1) ^ (y & 1)) == 1) {
                    ans ++;
                }
                x >>= 1;
                y >>= 1;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}