//给定一个 正整数 num ，编写一个函数，如果 num 是一个完全平方数，则返回 true ，否则返回 false 。 
//
// 进阶：不要 使用任何内置的库函数，如 sqrt 。 
//
// 
//
// 示例 1： 
//
// 
//输入：num = 16
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：num = 14
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= num <= 2^31 - 1 
// 
// Related Topics 数学 二分查找 👍 312 👎 0


package leetcode.editor.cn;
public class ValidPerfectSquare{
  public static void main(String[] args) {
       Solution solution = new ValidPerfectSquare().new Solution();
       System.out.println(solution.isPerfectSquare(14));
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPerfectSquare(int num) {
        long l = 1, r = Integer.MAX_VALUE;
        while (l < r) {
            long mid = l + (r - l) / 2;
            long mid2 = mid * mid;
            if (mid2 > num) {
                r = mid;
            } else if (mid2 < num) {
                l = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
