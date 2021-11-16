package leetcode.editor.cn;

//Java：数字转换为十六进制数
public class ConvertANumberToHexadecimal {
    public static void main(String[] args) {
        Solution solution = new ConvertANumberToHexadecimal().new Solution();
        // TO TEST
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String toHex(int num) {
        if (num == 0) {
            return "0";
        }
        StringBuffer sb = new StringBuffer();
        String hex = "0123456789abcdef";
        for (int i = 1; i <= 8 && num != 0; i ++) {
            int res = num & 0xf;
            sb.append(hex.charAt(res));
            num >>= 4;
        }
        return sb.reverse().toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}