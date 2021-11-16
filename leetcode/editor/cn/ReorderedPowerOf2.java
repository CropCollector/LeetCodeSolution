//给定正整数 N ，我们按任何顺序（包括原始顺序）将数字重新排序，注意其前导数字不能为零。 
//
// 如果我们可以通过上述方式得到 2 的幂，返回 true；否则，返回 false。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 输入：1
//输出：true
// 
//
// 示例 2： 
//
// 输入：10
//输出：false
// 
//
// 示例 3： 
//
// 输入：16
//输出：true
// 
//
// 示例 4： 
//
// 输入：24
//输出：false
// 
//
// 示例 5： 
//
// 输入：46
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 1 <= N <= 10^9 
// 
// Related Topics 数学 计数 枚举 排序 👍 130 👎 0


package leetcode.editor.cn;

public class ReorderedPowerOf2 {
    public static void main(String[] args) {
        Solution solution = new ReorderedPowerOf2().new Solution();
        System.out.println(solution.reorderedPowerOf2(46));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean reorderedPowerOf2(int n) {
            String s = String.valueOf(n);
            return rec(s, "");
        }

        private boolean rec(String s, String cur) {
            if (cur.startsWith("0")) {
                return false;
            }
            if (s.equals("")) {
                return check(cur);
            }
            for (int i = 0; i < s.length(); i++) {
                if (rec(s.substring(0, i) + s.substring(i + 1, s.length()), cur + s.charAt(i))) {
                    return true;
                }
            }
            return false;
        }

        private boolean check(String cur) {
            Integer i = Integer.parseInt(cur);
            while (i % 2 == 0) {
                i /= 2;
            }
            return i == 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
