package leetcode.editor.cn;

//Java：Excel表列名称
public class ExcelSheetColumnTitle {
    public static void main(String[] args) {
        Solution solution = new ExcelSheetColumnTitle().new Solution();
        // TO TEST
        System.out.println(solution.convertToTitle(52));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String convertToTitle(int columnNumber) {
        int scale = 26;
        StringBuffer result = new StringBuffer();
        while (columnNumber != 0) {
            int y = columnNumber % scale;
            if (y != 0) {
                result.insert(0, (char)(y - 1 + 'A'));
            } else {
                result.insert(0, (char)('Z'));
                columnNumber -= 26;
            }
            columnNumber = columnNumber / scale;
        }
        return result.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}