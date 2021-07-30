package leetcode.editor.cn;

//Java：Excel 表列序号
public class ExcelSheetColumnNumber {
    public static void main(String[] args) {
        Solution solution = new ExcelSheetColumnNumber().new Solution();
        // TO TEST
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int titleToNumber(String columnTitle) {
        columnTitle = new StringBuilder(columnTitle).reverse().toString();
        int ans = 0;
        for (int i = 0; i < columnTitle.length(); i++) {
            char c = columnTitle.charAt(i);
            ans += Math.pow(26, i) * (c - 'A' + 1);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}