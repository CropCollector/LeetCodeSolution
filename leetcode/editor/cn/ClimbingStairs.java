package leetcode.editor.cn;

//Java：爬楼梯
public class ClimbingStairs {
    public static void main(String[] args) {
        Solution solution = new ClimbingStairs().new Solution();
        // TO TEST
        System.out.println(solution.climbStairs(45));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int step1 = 1, step2 = 2, count = 0;
        for (int i = 3; i <= n; i ++) {
            count = step1 + step2;
            step1 = step2;
            step2 = count;
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}