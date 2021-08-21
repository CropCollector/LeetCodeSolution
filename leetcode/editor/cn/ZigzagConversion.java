package leetcode.editor.cn;

//Java：Z 字形变换
public class ZigzagConversion {
    public static void main(String[] args) {
        Solution solution = new ZigzagConversion().new Solution();
        // TO TEST
        System.out.println(solution.convert("A", 1));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        // 1 - 1 + 0 | 2 - 1 + 1 | 3 - 1 + 3 | n - 1 + (2 * (n - 1)  - 1)
        StringBuffer ans = new StringBuffer();
        int group = 2 * numRows - 2;
        // 每组取的顺序 123456789 -> 1 29 38 47 56
        for (int i = 0; i < s.length(); i += group) {
            ans.append(s.charAt(i));
        }
        for (int start = 1, end = group - 1; start <= end; start ++, end --) {
            for (int i = 0; i < s.length(); i += group) {
                if (i + start < s.length()) {
                    ans.append(s.charAt(i + start));
                }
                if (start != end && i + end < s.length()) {
                    ans.append(s.charAt(i + end));
                }
            }
        }
        return ans.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}