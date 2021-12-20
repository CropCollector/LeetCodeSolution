package leetcode.editor.cn;

//Java：换酒问题
public class WaterBottles {
    public static void main(String[] args) {
        Solution solution = new WaterBottles().new Solution();
        // TO TEST
        System.out.println(solution.numWaterBottles(9, 3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numWaterBottles(int numBottles, int numExchange) {
            int ans = 0;
            while (numBottles / numExchange > 0) {
                int remain = numBottles % numExchange;
                int exchanged = numBottles / numExchange;
                ans += numBottles - remain;
                numBottles = exchanged + remain;
            }
            return ans + numBottles;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}