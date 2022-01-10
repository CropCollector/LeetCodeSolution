package leetcode.editor.cn;

//Java：完美数
public class PerfectNumber {
    public static void main(String[] args) {
        Solution solution = new PerfectNumber().new Solution();
        // TO TEST
        System.out.println(solution.checkPerfectNumber(28));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean checkPerfectNumber(int num) {
            if (num == 1) {
                return false;
            }
            int sum = 1;
            for (int i = 2; i <= num / 2; i++) {
                sum += (num % i == 0) ? i : 0;
            }
            return sum == num;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}