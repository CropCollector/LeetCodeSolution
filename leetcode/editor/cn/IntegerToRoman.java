package leetcode.editor.cn;

//Java：整数转罗马数字
public class IntegerToRoman {
    public static void main(String[] args) {
        Solution solution = new IntegerToRoman().new Solution();
        // TO TEST
        System.out.println(solution.intToRoman(1994));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    String[][] ENUMS = {{"I", "V", "X"}, {"X", "L", "C"}, {"C", "D", "M"}, {"M"}};

    public String intToRoman(int num) {
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < 4 && num != 0; i++, num /= 10) {
            StringBuffer sb = new StringBuffer();
            int n = num % 10;
            if (n < 4) {
                for (int j = 0; j < n; j++) {
                    sb.append(ENUMS[i][0]);
                }
            } else if (n == 4) {
                sb.append(ENUMS[i][0] + ENUMS[i][1]);
            } else if (n >= 5 && n < 9) {
                sb.append(ENUMS[i][1]);
                for (int j = 5; j < n; j++) {
                    sb.append(ENUMS[i][0]);
                }
            } else {
                sb.append(ENUMS[i][0] + ENUMS[i][2]);
            }
            result = sb.append(result);
        }
        return result.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}